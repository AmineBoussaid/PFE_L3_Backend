package ma.radeef.interventions.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ma.radeef.interventions.endpoints.dtos.ReclamationStatusCount;
import ma.radeef.interventions.models.Reclamation;

@Service
public interface ReclamationService {
	
	/* sauvegarder */
	void save(Reclamation reclamation);
	
	/* lister par Id*/
	Reclamation getById(Long id);
	
	/* lister par IdFonctionnel*/
	Reclamation getByIdFonctionnel(String idFonctionnel);
	
	/* lister par nomClient*/
	List<Reclamation> getByNomClient(String nomClient);
	
	/* lister tous les Reclamation*/
	List<Reclamation> getAll();
	
	/* count status */
    List<ReclamationStatusCount> countReclamationsByStatus();

	
}
