package ma.radeef.interventions.endpoints;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.endpoints.dtos.InterventionDto;
import ma.radeef.interventions.endpoints.dtos.mappers.InterventionDtoMapper;
import ma.radeef.interventions.endpoints.errors.NotFoundException;
import ma.radeef.interventions.models.Intervention;
import ma.radeef.interventions.models.Roles;
import ma.radeef.interventions.models.User;
import ma.radeef.interventions.services.InterventionService;

@RestController
@RequestMapping("/api/interventions")
@Secured({Roles.CHEF_DEPARTEMENT,Roles.CHEF_SERVICE,Roles.TECHNICIEN})
@RequiredArgsConstructor
public class InterventionEndpoint {
	
	private final InterventionService interventionService;
	private final InterventionDtoMapper interventionDtoMapper;
	
	@PostMapping("/add")
	@Secured({Roles.CHEF_DEPARTEMENT,Roles.CHEF_SERVICE})
	public void add(@RequestBody InterventionDto interventionDto, @AuthenticationPrincipal User user) {
		Intervention intervention = interventionDtoMapper.toBean(interventionDto);
		interventionService.add(intervention,user.getId());
	}
	
	@DeleteMapping("deleteById/{id}")
	@Secured({Roles.CHEF_DEPARTEMENT,Roles.CHEF_SERVICE})
    public ResponseEntity<Void> deleteById(@PathVariable Long id, @AuthenticationPrincipal User user) {
        boolean isDeleted = interventionService.deleteById(id,user.getId());
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
    @PutMapping("/update")
    public InterventionDto updateIntervention(@RequestBody InterventionDto interventionDto, @AuthenticationPrincipal User user) {
    	Intervention newIntervention = interventionDtoMapper.toBean(interventionDto);
        return interventionDtoMapper.toDto(interventionService.updateIntervention(newIntervention, user.getId())); 
    }
	
	@GetMapping("/getAll")
	@Secured({Roles.CHEF_DEPARTEMENT,Roles.CHEF_SERVICE})
	public List<InterventionDto> getAll(){
		return interventionService.getAll().stream().map(i -> interventionDtoMapper.toDto(i)).toList();
	}
	
	@GetMapping("/getById/{id}")
	public InterventionDto getById(@PathVariable Long id){
		return interventionDtoMapper.toDto(interventionService.getById(id));
	}
	
	@GetMapping("/getByServiceId/{serviceId}")
	public List<InterventionDto> getByServiceId(@PathVariable Long serviceId){
		return interventionService.getByServiceId(serviceId).stream().map(i -> interventionDtoMapper.toDto(i)).toList();
		
	}
	
	@GetMapping("/getByDepartementId/{departementId}")
	public List<InterventionDto> getByDepartementId(@PathVariable Long departementId){
		return interventionService.getByDepartementId(departementId).stream().map(i -> interventionDtoMapper.toDto(i)).toList();
	}
	
	@GetMapping("/getByTechnicienId/{technicienId}")
	public List<InterventionDto> getByTechnicienId(@PathVariable Long technicienId){
		return interventionService.getByTechnicienId(technicienId).stream().map(i -> interventionDtoMapper.toDto(i)).toList();
	}
	
	@GetMapping("/getByIdFonctionnel/{idFonctionnel}")
	public InterventionDto getByIdFonctionnel(@PathVariable String idFonctionnel) {
		Intervention intervention = interventionService.getByReclamationIdFonctionnel(idFonctionnel).orElseThrow(() -> new NotFoundException());
		return interventionDtoMapper.toDto(intervention);
	}
	
	@GetMapping("/getByCreateurId/{createurId}")
	public List<InterventionDto> getByCreateurId(@PathVariable Long createurId){
		return interventionService.getByCreateurId(createurId).stream().map(i -> interventionDtoMapper.toDto(i)).toList();
	}
	
	@GetMapping("/getListDate/{technicienId}")
	public List<LocalDate> getListDate(@PathVariable Long technicienId){
		return interventionService.getListDate(technicienId);
	}
	
	@GetMapping("getByChefOrTechnicien/{technicienId}")
	public List<InterventionDto> getByChefOrTechnicien(@PathVariable Long technicienId) {
		return interventionService.getByChefOrTechnicien(technicienId).stream().map(i -> interventionDtoMapper.toDto(i)).toList();
	
	}
	
	
}
