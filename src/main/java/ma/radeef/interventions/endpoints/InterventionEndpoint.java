package ma.radeef.interventions.endpoints;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
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
import ma.radeef.interventions.services.InterventionService;

@RestController
@RequestMapping("/api/interventions")
@RequiredArgsConstructor
public class InterventionEndpoint {
	
	private final InterventionService interventionService;
	private final InterventionDtoMapper interventionDtoMapper;
	
	@PostMapping("/add/{userId}")
	public void add(@RequestBody InterventionDto interventionDto, @PathVariable("userId") Long userId) {
		Intervention intervention = interventionDtoMapper.toBean(interventionDto);
		interventionService.add(intervention,userId);
	}
	
	@DeleteMapping("deleteById/{id}/{userId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id, @PathVariable("userId") Long userId) {

        boolean isDeleted = interventionService.deleteById(id,userId);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
    @PutMapping("/update/{userId}")
    public InterventionDto updateIntervention(@RequestBody InterventionDto interventionDto, @PathVariable("userId") Long userId) {
    	Intervention newIntervention = interventionDtoMapper.toBean(interventionDto);
        return interventionDtoMapper.toDto(interventionService.updateIntervention(newIntervention, userId)); 
    }
	
	@GetMapping("/getAll")
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
