package ma.radeef.interventions.endpoints;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.endpoints.dtos.ReclamationDto;
import ma.radeef.interventions.endpoints.dtos.mappers.ReclamationDtoMapper;
import ma.radeef.interventions.endpoints.errors.NotFoundException;
import ma.radeef.interventions.models.Reclamation;
import ma.radeef.interventions.services.ReclamationService;

@RestController
@RequestMapping("/api/reclamations")
@RequiredArgsConstructor
public class ReclamationEndpoint {

	private final ReclamationService reclamationService;
	private final ReclamationDtoMapper reclamationDtoMapper;

	
	@PostMapping("/add/{userId}")
	public void add(@RequestBody ReclamationDto reclamationDto,@PathVariable("userId") Long userId) {
		Reclamation reclamation = reclamationDtoMapper.toBean(reclamationDto);
		reclamationService.save(reclamation, userId);
	}
	
	
    @PutMapping("/update/{userId}")
    public ReclamationDto updateReclamation(@RequestBody ReclamationDto reclamationDto, @PathVariable("userId") Long userId) {
    	Reclamation reclamation = reclamationDtoMapper.toBean(reclamationDto);
        return reclamationDtoMapper.toDto(reclamationService.updateReclamation(reclamation,userId));
    }
    
    @DeleteMapping("/deleteById/{id}/{userId}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id, @PathVariable("userId") Long userId) {
        boolean isDeleted = reclamationService.deleteById(id,userId);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

	
	@GetMapping("/getAll")
	public List<ReclamationDto> getAll(){
		return reclamationService.getAll().stream().map(reclamation -> reclamationDtoMapper.toDto(reclamation)).toList();
		
	}
	
	@GetMapping("/getById/{id}")
	public ReclamationDto getById(@PathVariable Long id) {
		
	    return reclamationDtoMapper.toDto(reclamationService.getById(id));
	}
	
	@GetMapping("/getByNomClient/{nomClient}")
	public List<ReclamationDto> getByNomClient(@PathVariable String nomClient)  {
	    return reclamationService.getByNomClient(nomClient).stream().map(reclamation -> reclamationDtoMapper.toDto(reclamation)).toList();
	}
	
	@GetMapping("/getByAgentId/{agentId}")
	public List<ReclamationDto> getByAgentId(@PathVariable Long agentId)  {
	    return reclamationService.getByAgentId(agentId).stream().map(reclamation -> reclamationDtoMapper.toDto(reclamation)).toList();
	}
	
	@GetMapping("/getByIdFonctionnel/{idFonctionnel}")
	public ReclamationDto getByIdFonctionnel(@PathVariable String idFonctionnel) {
	    Reclamation reclamation = reclamationService.getByIdFonctionnel(idFonctionnel);
        if (reclamation != null) {
        	ReclamationDto reclamationDto = reclamationDtoMapper.toDto(reclamation);
            return reclamationDto;
        } else {
            throw new NotFoundException();
        }
	}
	
	@GetMapping("/getByServiceId/{serviceId}")
	public List<ReclamationDto> getByServiceId(@PathVariable Long serviceId) {
		return reclamationService.getByServiceId(serviceId).stream().map(reclamation -> reclamationDtoMapper.toDto(reclamation)).toList();
	}
	
	@GetMapping("/getByDepartementId/{departementId}")
	public List<ReclamationDto> getByDepartementId(@PathVariable Long departementId) {
		return reclamationService.getByDepartementId(departementId).stream().map(reclamation -> reclamationDtoMapper.toDto(reclamation)).toList();
	}    
	
}
