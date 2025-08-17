package ma.radeef.interventions.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ma.radeef.interventions.models.TechnicienEquipe;

@Service
public interface TechnicienEquipeService {
	
	void save(TechnicienEquipe technicienEquipe);
	
	List<TechnicienEquipe> getAll();
	
    public boolean deleteByTechnicienEquipe(Long technicienId, Long equipeId);


}
