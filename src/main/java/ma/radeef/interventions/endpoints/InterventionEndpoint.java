package ma.radeef.interventions.endpoints;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.models.Intervention;
import ma.radeef.interventions.services.InterventionService;

@RestController
@RequestMapping("/api/interventions")
@RequiredArgsConstructor
public class InterventionEndpoint {
	
	private final InterventionService interventionService;
	
	@PostMapping
	public void add(@RequestBody Intervention intervention) {
		interventionService.save(intervention);
	}
	
	@GetMapping
	public List<Intervention> getAll(){
		return interventionService.getAll();
		
	}

}
