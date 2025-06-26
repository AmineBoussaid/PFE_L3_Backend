package ma.radeef.interventions.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ma.radeef.interventions.models.Reclamation;

@Service
public interface ReclamationService {
	
	void save(Reclamation reclamation);
	
	Reclamation getById(Long id);
	
	Reclamation getByIdFonctionnel(String idFonctionnel);
	
	List<Reclamation> getAll();
	
}
