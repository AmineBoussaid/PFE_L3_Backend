package ma.radeef.interventions.endpoints;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.endpoints.dtos.ReclamationStatusCount;
import ma.radeef.interventions.models.Reclamation;
import ma.radeef.interventions.services.ReclamationService;

@RestController
@RequestMapping("/api/reclamations")
@RequiredArgsConstructor
public class ReclamationEndpoint {

	private final ReclamationService reclamationService;
	/*private final ReclamationDtoMapper reclamationDtoMapper;*/

	
	@PostMapping("/add")
	public void add(@RequestBody Reclamation reclamation) {
		reclamationService.save(reclamation);
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
	
	@GetMapping("/getByIdFonctionnel/{idFonctionnel}")
	public Reclamation getByIdFonctionnel(@PathVariable String idFonctionnel) {
	    return reclamationService.getByIdFonctionnel(idFonctionnel);
	}
	
    @GetMapping("/status")
    public List<ReclamationStatusCount> countReclamationsByStatus() {
        return reclamationService.countReclamationsByStatus();
    }
	
}
