package ma.radeef.interventions.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.models.Rapport;
import ma.radeef.interventions.repositories.RapportRepository;
import ma.radeef.interventions.services.RapportService;

@Service
@RequiredArgsConstructor
public class RapportServiceImpl implements RapportService {	
	
	private final RapportRepository rapportRepository;
	
	@Override
	public void save(Rapport rapport) {
		// TODO Auto-generated method stub
		rapportRepository.save(rapport);
	}

	@Override
	public List<Rapport> getAll() {
		// TODO Auto-generated method stub
		return rapportRepository.findAll();
	}

	@Override
	public Rapport getByInterventionId(Long interventionId) {
		// TODO Auto-generated method stub
		return rapportRepository.findByInterventionId(interventionId);
	}

}
