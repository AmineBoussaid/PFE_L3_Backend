package ma.radeef.interventions.endpoints;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.services.TechnicienEquipeService;

@RestController
@RequestMapping("/api/technicien-equipes")
@RequiredArgsConstructor
public class TechnicienEquipeEndpoint {
	
	private final TechnicienEquipeService technicienEquipeService;
	
	@DeleteMapping("deleteByTechnicienEquipe/{technicienId}/{equipeId}")
	public ResponseEntity<Void> deleteByTechnicienEquipe(@PathVariable("technicienId") Long technicienId, @PathVariable("equipeId") Long equipeId){
		boolean isDeleted =  technicienEquipeService.deleteByTechnicienEquipe(technicienId,equipeId);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
            
        } else {
            return ResponseEntity.notFound().build();
        }
	}
	
	@DeleteMapping("deleteByEquipeId/{equipeId}")
	public ResponseEntity<Void> deleteByEquipeId(@PathVariable("equipeId") Long equipeId){
		boolean isDeleted =  technicienEquipeService.deleteByEquipeId(equipeId);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
            
        } else {
            return ResponseEntity.notFound().build();
        }
	}
	
}
