package ma.radeef.interventions.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ma.radeef.interventions.models.Intervention;
import ma.radeef.interventions.models.InterventionHist;

@Service
public interface InterventionHistService {
	
	void save(InterventionHist interventionHist);
	
	/* lister tous les InterventionHist*/
	List<InterventionHist> getAll();
	
	/* lister par Id*/
	List<InterventionHist> getByInterventionId(Long interventionId);

}
