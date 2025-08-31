package ma.radeef.interventions.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ma.radeef.interventions.models.InterventionHistorique;

@Service
public interface InterventionHistoriqueService {
	
	void save(InterventionHistorique interventionHistorique);
	
	List<InterventionHistorique> getAll();
	
	List<InterventionHistorique> getByInterventionId(Long interventionId);

}
