package ma.radeef.interventions.endpoints;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.models.InterventionHistorique;
import ma.radeef.interventions.services.InterventionHistoriqueService;

@RestController
@RequestMapping("/api/interventions-historique")
@RequiredArgsConstructor
public class InterventionHistEndpoint {
	
	private final InterventionHistoriqueService interventionHistoriqueService;
	
	@PostMapping
	public void add(@RequestBody InterventionHistorique interventionHistorique) {
		interventionHistoriqueService.save(interventionHistorique);
	}
	
	@GetMapping
	public List<InterventionHistorique> getAll(){
		return interventionHistoriqueService.getAll();
	}
	
	@GetMapping("/getByIntervention/{interventionId}")
	public List<InterventionHistorique> getByIntervention(@PathVariable Long interventionId ) {
		return interventionHistoriqueService.getByInterventionId(interventionId);
	}

}
