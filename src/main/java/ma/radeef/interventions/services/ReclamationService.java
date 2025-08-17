package ma.radeef.interventions.services;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import ma.radeef.interventions.models.Reclamation;
import ma.radeef.interventions.models.ReclamationStatut;

@Service
public interface ReclamationService {
	
	/* sauvegarder */
	void save(Reclamation reclamation,Long userId, HttpServletRequest request);
	
	Reclamation updateReclamation(Reclamation reclamation, Long userId, HttpServletRequest request);
	
    /* delete par id */
    public boolean deleteById(Long id,Long userId, HttpServletRequest request);
	
	/* lister tous les Reclamation*/
	List<Reclamation> getAll();
	
	/* lister par Id*/
	Reclamation getById(Long id);
	
	/* lister par IdFonctionnel*/
	Reclamation getByIdFonctionnel(String idFonctionnel);
	
	/* lister par nomClient*/
	List<Reclamation> getByNomClient(String nomClient);
	
	/* lister par AgentId*/
	List<Reclamation> getByAgentId(Long agentId);
	
	/* lister par ServiceId*/
	List<Reclamation> getByServiceId(Long serviceId);
	
	/* lister par DepartementId*/
	List<Reclamation> getByDepartementId(Long departementId);
	
	Reclamation updateReclamationStatus(Reclamation reclamation, String reclamationStatut);
    
    


    
    

	
}
