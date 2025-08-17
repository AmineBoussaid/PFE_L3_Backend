package ma.radeef.interventions.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ma.radeef.interventions.models.ServiceD;

@Service
public interface ServiceDService {
	
	void save(ServiceD serviceD);
	
    List<ServiceD> getAll();
	
	ServiceD getById(Long id);
	
	List<ServiceD> getByDepartementId(Long departementId);
    
	ServiceD getByChefServiceId(Long chefServiceId);

}
