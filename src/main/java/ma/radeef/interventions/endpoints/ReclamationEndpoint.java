package ma.radeef.interventions.endpoints;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.endpoints.dtos.ReclamationDto;
import ma.radeef.interventions.endpoints.dtos.mappers.ReclamationDtoMapper;
import ma.radeef.interventions.models.Reclamation;
import ma.radeef.interventions.services.ReclamationService;

@RestController
@RequestMapping("/api/reclamations")
@RequiredArgsConstructor
public class ReclamationEndpoint {

	private final ReclamationService reclamationService;
	private final ReclamationDtoMapper reclamationDtoMapper;

	
	@PostMapping
	public void add(@RequestBody Reclamation reclamation) {
		reclamationService.save(reclamation);
	}
	
	@GetMapping
	public List<ReclamationDto> getAll(){
		return reclamationService.getAll().stream().map(reclamation -> reclamationDtoMapper.toDto(reclamation)).toList();
		
	}
	
	
}
