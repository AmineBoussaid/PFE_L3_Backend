package ma.radeef.interventions.endpoints;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.endpoints.dtos.RapportDto;
import ma.radeef.interventions.endpoints.dtos.mappers.RapportDtoMapper;
import ma.radeef.interventions.models.Rapport;
import ma.radeef.interventions.services.RapportService;

@RestController
@RequestMapping("/api/rapports")
@RequiredArgsConstructor
public class RapportEndpoint {

	private final RapportService rapportService;
	private final RapportDtoMapper rapportDtoMapper;
	
	@PostMapping("/add")
	public void add(@RequestBody Rapport rapport) {
		rapportService.save(rapport);
	}
	
	@GetMapping("/getAll")
	public List<RapportDto> getAll(){
		return rapportService.getAll().stream().map(r -> rapportDtoMapper.toDto(r)).toList();
	}
	
	@GetMapping("/getByInterventionId/{interventionId}")
	public RapportDto getByInterventionId(@PathVariable("interventionId") Long interventionId){
		Rapport rapport = rapportService.getByInterventionId(interventionId);
		return rapportDtoMapper.toDto(rapport);
	}
	
	
}
