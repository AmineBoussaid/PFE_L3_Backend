package ma.radeef.interventions.endpoints;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.endpoints.dtos.DepartementDto;
import ma.radeef.interventions.endpoints.dtos.mappers.DepartementDtoMapper;
import ma.radeef.interventions.models.Departement;
import ma.radeef.interventions.models.Roles;
import ma.radeef.interventions.services.DepartementService;

@RestController
@RequestMapping("/api/departements")
@Secured({Roles.AGENT, Roles.TECHNICIEN})
@RequiredArgsConstructor
public class DepatementEndpoint {
	
	private final DepartementService departementService;
	private final DepartementDtoMapper departementDtoMapper;
	
	@PostMapping("/add")
	public void add(@RequestBody Departement departement) {
		departementService.save(departement);
	}
	
	@GetMapping("/getAll")
	public List<DepartementDto> getAll(){
		return departementService.getAll().stream().map(d -> departementDtoMapper.toDto(d)).toList();
	}
	
    @GetMapping("/getByChefDepartement/{chefDepartementId}")
    public DepartementDto getByChefDepartement(@PathVariable Long chefDepartementId) {
        return departementDtoMapper.toDto(departementService.getByChefDepartement(chefDepartementId));
    }
    
}

