package ma.radeef.interventions.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ma.radeef.interventions.models.Intervention;

@Service
public interface InterventionService {
	
	void save(Intervention intervention);
	
	Intervention getById(Long id);
	
	List<Intervention> getAll();
	
	/* lister par ServiceId*/
	List<Intervention> getByServiceId(Long serviceId);
	
	/* lister par ServiceId*/
	List<Intervention> getByDepartementId(Long departementId);
	
    /* delete par id */
    public boolean deleteById(Long id);


}
