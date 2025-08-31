package ma.radeef.interventions.endpoints;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.endpoints.dtos.ServiceDto;
import ma.radeef.interventions.endpoints.dtos.mappers.ServiceDtoMapper;
import ma.radeef.interventions.models.Service;
import ma.radeef.interventions.services.ServiceService;

@RestController
@RequestMapping("/api/services")
@RequiredArgsConstructor
public class ServiceEndpoint {
	
    private final ServiceService serviceService;
    private final ServiceDtoMapper serviceDtoMapper;
    
	@PostMapping("/add")
    public void add(@RequestBody Service service) {
        serviceService.save(service);
    }


	@GetMapping("/getAll")
    public List<ServiceDto> getAll() {
        return serviceService.getAll().stream().map(s -> serviceDtoMapper.toDto(s)).toList();
    }
    
    @GetMapping("/getById/{id}")
    public ServiceDto getById(@PathVariable Long id) {
        return serviceDtoMapper.toDto(serviceService.getById(id));
    }
    
    @GetMapping("/getByDepartementId/{departementId}")
    public List<ServiceDto> getByDepartementId(@PathVariable Long departementId) {
        return serviceService.getByDepartementId(departementId).stream().map(s -> serviceDtoMapper.toDto(s)).toList();
    }

    
    @GetMapping("/getByChefService/{chefServiceId}")
    public ServiceDto getByChefService(@PathVariable Long chefServiceId ) {
        return serviceDtoMapper.toDto(serviceService.getByChefServiceId(chefServiceId)) ;
    }
    


}
