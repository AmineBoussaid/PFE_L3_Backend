package ma.radeef.interventions.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ma.radeef.interventions.endpoints.dtos.ReclamationStatusCount;
import ma.radeef.interventions.models.Reclamation;

@Service
public interface ReclamationService {
	
	/* sauvegarder */
	void save(Reclamation reclamation);
	
	Reclamation updateReclamation(Reclamation reclamation);
	
    /* delete par id */
    public boolean deleteById(Long id);
	
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
	
	/* count status */
    List<ReclamationStatusCount> countReclamationsByStatus();
    
    


    
    

	
}
