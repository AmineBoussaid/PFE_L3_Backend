package ma.radeef.interventions.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ma.radeef.interventions.models.Rapport;

@Service
public interface RapportService {
	
	void save(Rapport rapport);

	List<Rapport> getAll();

	Rapport getByInterventionId(Long interventionId);

}
