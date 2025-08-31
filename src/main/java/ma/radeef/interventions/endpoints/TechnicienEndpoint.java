package ma.radeef.interventions.endpoints;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.endpoints.dtos.TechnicienDto;
import ma.radeef.interventions.endpoints.dtos.mappers.TechnicienDtoMapper;
import ma.radeef.interventions.models.Technicien;
import ma.radeef.interventions.services.TechnicienService;

@RestController
@RequestMapping("/api/techniciens")
@RequiredArgsConstructor
public class TechnicienEndpoint {

	private final TechnicienService technicienService;
	private final TechnicienDtoMapper technicienDtoMapper;
	
	@GetMapping("/getById/{id}")
	public TechnicienDto getById(@PathVariable Long id) {
	    Technicien technicien = technicienService.getById(id)
	                           .orElseThrow(() -> new RuntimeException("Technicien not found with id " + id));
	    return technicienDtoMapper.toDto(technicien);
	}

	
	@GetMapping("/getByServiceId/{serviceId}")
	public List<TechnicienDto> getByServiceId(@PathVariable Long serviceId) {
		return technicienService.getByServiceId(serviceId).stream().map(t -> technicienDtoMapper.toDto(t)).toList();
	}


}
