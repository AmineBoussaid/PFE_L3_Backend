package ma.radeef.interventions.endpoints;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.endpoints.dtos.InterventionDTO;
import ma.radeef.interventions.endpoints.dtos.TechnicienDto;
import ma.radeef.interventions.models.Intervention;
import ma.radeef.interventions.services.InterventionService;

@RestController
@RequestMapping("/api/interventions")
@RequiredArgsConstructor
public class InterventionEndpoint {
	
	private final InterventionService interventionService;
	
	@PostMapping("/add/{userId}")
	public void add(@RequestBody InterventionDTO interventionDTO, @PathVariable("userId") Long userId, HttpServletRequest request) {
		Intervention intervention = interventionDTO.getIntervention();
		System.out.println(intervention.toString());
		List<TechnicienDto> technicienDto = interventionDTO.getTechniciens();
		interventionService.save(intervention,technicienDto,userId,request);
	}
	
	@DeleteMapping("deleteById/{id}/{userId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id, @PathVariable("userId") Long userId,HttpServletRequest request) {
        boolean isDeleted = interventionService.deleteById(id,userId,request);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
    @PutMapping("/update/{userId}")
    public Intervention updateIntervention(@RequestBody InterventionDTO interventionDTO, @PathVariable("userId") Long userId, HttpServletRequest request) {
    	Intervention newIntervention = interventionDTO.getIntervention();
		List<TechnicienDto> technicienDto = interventionDTO.getTechniciens();
        return interventionService.updateIntervention(newIntervention, technicienDto, userId, request);
    }
	
	@GetMapping("/getAll")
	public List<Intervention> getAll(){
		return interventionService.getAll();
	}
	
	@GetMapping("/getById/{id}")
	public Intervention getById(@PathVariable Long id){
		return interventionService.getById(id);
	}
	
	@GetMapping("/getByServiceId/{serviceId}")
	public List<Intervention> getByServiceId(@PathVariable Long serviceId){
		return interventionService.getByServiceId(serviceId);
		
	}
	
	@GetMapping("/getByDepartementId/{departementId}")
	public List<Intervention> getByDepartementId(@PathVariable Long departementId){
		return interventionService.getByDepartementId(departementId);
	}
	
	@GetMapping("/getByTechnicienId/{technicienId}")
	public List<Intervention> getByTechnicienId(@PathVariable Long technicienId){
		return interventionService.getByTechnicienId(technicienId);
	}
	
	@GetMapping("/getByIdFonctionnel/{idFonctionnel}")
	public ResponseEntity<Intervention> getByIdFonctionnel(@PathVariable String idFonctionnel) {
		Intervention intervention = interventionService.getByReclamationIdFonctionnel(idFonctionnel);
        if (intervention != null) {
            return ResponseEntity.ok(intervention);
        } else {
            return ResponseEntity.notFound().build();
        }
	}
	
	@GetMapping("/getByCreateurId/{createurId}")
	public List<Intervention> getByCreateurId(@PathVariable Long createurId){
		return interventionService.getByCreateurId(createurId);
	}
	
	@GetMapping("/getListDate/{technicienId}")
	public List<LocalDate> getListDate(@PathVariable Long technicienId){
		return interventionService.getListDate(technicienId);
	}
	
	
}
