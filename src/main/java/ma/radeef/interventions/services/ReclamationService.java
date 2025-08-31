package ma.radeef.interventions.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ma.radeef.interventions.models.Reclamation;

@Service
public interface ReclamationService {
	
	void save(Reclamation reclamation,Long userId);
	
	Reclamation updateReclamation(Reclamation reclamation, Long userId);
	
    public boolean deleteById(Long id,Long userId);
	
	List<Reclamation> getAll();
	
	Reclamation getById(Long id);
	
	Reclamation getByIdFonctionnel(String idFonctionnel);
	
	List<Reclamation> getByNomClient(String nomClient);
	
	List<Reclamation> getByAgentId(Long agentId);
	
	List<Reclamation> getByServiceId(Long serviceId);
	
	List<Reclamation> getByDepartementId(Long departementId);
	
	Reclamation updateReclamationStatus(Reclamation reclamation, String reclamationStatut);
	
}
