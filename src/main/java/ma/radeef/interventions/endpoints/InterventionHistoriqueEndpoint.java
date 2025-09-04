package ma.radeef.interventions.endpoints;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.endpoints.dtos.InterventionHistoriqueDto;
import ma.radeef.interventions.endpoints.dtos.mappers.InterventionHistoriqueMapper;
import ma.radeef.interventions.services.InterventionHistoriqueService;

@RestController
@RequestMapping("/api/interventions-historique")
@RequiredArgsConstructor
public class InterventionHistoriqueEndpoint {
	
	private final InterventionHistoriqueService historiqueService;
	private final InterventionHistoriqueMapper historiqueMapper;
	
	
	@GetMapping("/getAll")
	public List<InterventionHistoriqueDto> getAll(){
		return historiqueService.getAll().stream().map(i -> historiqueMapper.toDto(i)).toList();
	}
	
	@GetMapping("/getByIntervention/{interventionId}")
	public List<InterventionHistoriqueDto> getByIntervention(@PathVariable Long interventionId ) {
		return historiqueService.getByInterventionId(interventionId).stream().map(i -> historiqueMapper.toDto(i)).toList();
	}

}
