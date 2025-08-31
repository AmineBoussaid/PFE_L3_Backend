package ma.radeef.interventions.endpoints;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.endpoints.dtos.EquipeDto;
import ma.radeef.interventions.endpoints.dtos.mappers.EquipeDtoMapper;
import ma.radeef.interventions.models.Equipe;
import ma.radeef.interventions.services.EquipeService;

@RestController
@RequestMapping("/api/equipes")
@RequiredArgsConstructor
public class EquipeEndpoint {
	
	private final EquipeService equipeService;
	private final EquipeDtoMapper equipeDtoMapper;
	
	@PostMapping("/add")
	public void add(@RequestBody Equipe equipe) {
		equipeService.save(equipe);
	}
	
	@GetMapping("/getAll")
	public List<EquipeDto> getAll(){
		return equipeService.getAll().stream().map(e -> equipeDtoMapper.toDto(e)).toList();
	}
	
	@DeleteMapping("deleteById/{id}")
	public ResponseEntity<Void> deleteBy(@PathVariable("id") Long id) {
        boolean isDeleted = equipeService.deleteById(id);
        
        if (isDeleted) {
            return ResponseEntity.noContent().build();
            
        } else {
            return ResponseEntity.notFound().build();
        }
	}
	
	@GetMapping("/getBySerice/{serviceId}")
	public List<EquipeDto> getByChefEquipeSericeServiceId(@PathVariable("serviceId") Long serviceId){
		return equipeService.getByChefEquipeSericeServiceId(serviceId).stream().map(e -> equipeDtoMapper.toDto(e)).toList();
	}
	
	
}
