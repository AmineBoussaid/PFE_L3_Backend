package ma.radeef.interventions.endpoints;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.models.Departement;
import ma.radeef.interventions.services.DepartementService;

@RestController
@RequestMapping("/api/departements")
@RequiredArgsConstructor
public class DepatementEndpoint {
	
	private final DepartementService departementService;
	
	@PostMapping("/add")
	public void add(@RequestBody Departement departement) {
		departementService.save(departement);
	}
	
	@GetMapping("/getAll")
	public List<Departement> getAll(){
		return departementService.getAll();
		
	}

}
