package ma.radeef.interventions.endpoints;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.models.ServiceD;
import ma.radeef.interventions.models.TechnicienSer;
import ma.radeef.interventions.services.TechnicienSerService;

@RestController
@RequestMapping("/api/technicien-services")
@RequiredArgsConstructor
public class TechnicienSerEndpoint {
	
	private final TechnicienSerService technicienSerService;
	
	@PostMapping("/add")
	public void add(@RequestBody TechnicienSer technicienService) {
		technicienSerService.save(technicienService);
	}
	
	@GetMapping("/getAll")
	public List<TechnicienSer> getAll(){
		return technicienSerService.getAll();
	}
	
	@DeleteMapping("deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        boolean isDeleted = technicienSerService.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	@GetMapping("/getServiceByTechnicienId/{technicienId}")
	public  Optional<ServiceD> getServiceByTechnicienId(@PathVariable Long technicienId) {
		return technicienSerService.getServiceByTechnicienId(technicienId);
	}
	
	@DeleteMapping("/deleteByTechnicienService/{technicienId}/{serviceId}")
	public boolean deleteByTechnicienService(@PathVariable Long technicienId, @PathVariable Long serviceId) {
		return technicienSerService.deleteByTechnicienService(technicienId, serviceId);
	}
	
}
