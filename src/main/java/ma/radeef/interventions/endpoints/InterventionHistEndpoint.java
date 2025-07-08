package ma.radeef.interventions.endpoints;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.models.Intervention;
import ma.radeef.interventions.models.InterventionHist;
import ma.radeef.interventions.services.InterventionHistService;

@RestController
@RequestMapping("/api/interventions-historique")
@RequiredArgsConstructor
public class InterventionHistEndpoint {
	
	private final InterventionHistService interventionHistService;
	
	@PostMapping
	public void add(@RequestBody InterventionHist interventionHist) {
		interventionHistService.save(interventionHist);
	}
	
	@GetMapping
	public List<InterventionHist> getAll(){
		return interventionHistService.getAll();
	}
	
	@GetMapping("/getByIntervention/{interventionId}")
	public List<InterventionHist> getByIntervention(@PathVariable Long interventionId ) {
		return interventionHistService.getByInterventionId(interventionId);
	}

}
