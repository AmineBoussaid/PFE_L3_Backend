package ma.radeef.interventions.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ma.radeef.interventions.models.ServiceD;
import ma.radeef.interventions.models.TechnicienSer;

@Service
public interface TechnicienSerService {
	
	void save(TechnicienSer technicienService);
	
	List<TechnicienSer> getAll();
	
	Optional<ServiceD> getServiceByTechnicienId(Long technicienId);
		
	/* delete par id */
    public boolean deleteById(Long id);
    
    public boolean deleteByTechnicienService(Long technicienId, Long serviceId);

}
