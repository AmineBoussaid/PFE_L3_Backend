package ma.radeef.interventions.services;

import java.util.List;

import ma.radeef.interventions.models.ServiceD;



@org.springframework.stereotype.Service
public interface ServiceDService {
	
	void save(ServiceD serviceD);
	
	ServiceD getById(Long id);
    
    List<ServiceD> getAll();

}
