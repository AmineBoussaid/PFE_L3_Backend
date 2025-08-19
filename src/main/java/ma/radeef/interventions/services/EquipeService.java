package ma.radeef.interventions.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ma.radeef.interventions.models.Equipe;

@Service
public interface EquipeService {
	
	void save(Equipe equipe);
	
	List<Equipe> getAll();
	
	public boolean deleteById(Long id);
	
}
