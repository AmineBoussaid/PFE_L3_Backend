package ma.radeef.interventions.endpoints;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.models.ServiceD;
import ma.radeef.interventions.services.ServiceDService;

@RestController
@RequestMapping("/api/services")
@RequiredArgsConstructor
public class ServiceEndpoint {
	
    private final ServiceDService serviceDService;
    
    @PostMapping
    public void add(@RequestBody ServiceD serviceD) {
        serviceDService.save(serviceD);
    }

    @GetMapping
    public List<ServiceD> getAll() {
        return serviceDService.getAll();
    }

    @GetMapping("/getById/{id}")
    public ServiceD getById(@PathVariable Long id) {
        return serviceDService.getById(id);
    }

}
