package ma.radeef.interventions.endpoints;

import java.net.http.HttpRequest;
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
import ma.radeef.interventions.endpoints.dtos.ReclamationStatusCount;
import ma.radeef.interventions.models.Reclamation;
import ma.radeef.interventions.services.ReclamationService;
import ma.radeef.interventions.services.UserHistService;
import ma.radeef.interventions.services.utils.GestionHistorique;

@RestController
@RequestMapping("/api/reclamations")
@RequiredArgsConstructor
public class ReclamationEndpoint {

	private final ReclamationService reclamationService;
	/*private final ReclamationDtoMapper reclamationDtoMapper;*/

	
	@PostMapping("/add/{userId}")
	public void add(@RequestBody Reclamation reclamation,@PathVariable("userId") Long userId, HttpServletRequest request) {
		reclamationService.save(reclamation, userId, request);
	}
	
	
    @PutMapping("/update/{userId}")
    public Reclamation updateReclamation(@RequestBody Reclamation reclamation, @PathVariable("userId") Long userId, HttpServletRequest request) {
        return reclamationService.updateReclamation(reclamation,userId, request);
    }
    
    @DeleteMapping("/deleteById/{id}/{userId}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id, @PathVariable("userId") Long userId,HttpServletRequest request) {
        boolean isDeleted = reclamationService.deleteById(id,userId,request);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

	
	@GetMapping("/getAll")
	public List<Reclamation> getAll(){
		//return reclamationService.getAll().stream().map(reclamation -> reclamationDtoMapper.toDto(reclamation)).toList();
		return reclamationService.getAll();
		
	}
	
	@GetMapping("/getById/{id}")
	public Reclamation getById(@PathVariable Long id) {
	    return reclamationService.getById(id);
	}
	
	@GetMapping("/getByNomClient/{nomClient}")
	public List<Reclamation> getByNomClient(@PathVariable String nomClient)  {
	    return reclamationService.getByNomClient(nomClient);
	}
	
	@GetMapping("/getByAgentId/{agentId}")
	public List<Reclamation> getByAgentId(@PathVariable Long agentId)  {
	    return reclamationService.getByAgentId(agentId);
	}
	
	@GetMapping("/getByIdFonctionnel/{idFonctionnel}")
	public ResponseEntity<Reclamation> getByIdFonctionnel(@PathVariable String idFonctionnel) {
	    Reclamation reclamation = reclamationService.getByIdFonctionnel(idFonctionnel);
        if (reclamation != null) {
            return ResponseEntity.ok(reclamation);
        } else {
            return ResponseEntity.notFound().build();
        }
	}
	
	@GetMapping("/getByServiceId/{serviceId}")
	public List<Reclamation> getByServiceId(@PathVariable Long serviceId) {
		return reclamationService.getByServiceId(serviceId);
	}
	
	@GetMapping("/getByDepartementId/{departementId}")
	public List<Reclamation> getByDepartementId(@PathVariable Long departementId) {
		return reclamationService.getByDepartementId(departementId);
	}
	
    @GetMapping("/status")
    public List<ReclamationStatusCount> countReclamationsByStatus() {
        return reclamationService.countReclamationsByStatus();
    }
    
	
}
