package ma.radeef.interventions.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ma.radeef.interventions.models.TechnicienSer;

@Service
public interface TechnicienSerService {
	
	void save(TechnicienSer technicienService);
	
	List<TechnicienSer> getAll();
	
	/* delete par id */
    public boolean deleteById(Long id);
}
