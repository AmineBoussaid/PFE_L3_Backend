package ma.radeef.interventions.services;

import java.util.List;

import ma.radeef.interventions.models.Service;


@org.springframework.stereotype.Service
public interface ServiceService {
	
	void save(Service service);
	
    List<Service> getAll();
	
	Service getById(Long id);
	
	List<Service> getByDepartementId(Long departementId);
    
	Service getByChefServiceId(Long chefServiceId);

}
