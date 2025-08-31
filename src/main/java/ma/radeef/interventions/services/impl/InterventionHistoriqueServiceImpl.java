package ma.radeef.interventions.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.models.InterventionHistorique;
import ma.radeef.interventions.repositories.InterventionHistoriqueRepository;
import ma.radeef.interventions.services.InterventionHistoriqueService;

@Service
@RequiredArgsConstructor
public class InterventionHistoriqueServiceImpl implements InterventionHistoriqueService{

	private final InterventionHistoriqueRepository interventionHistoriqueRepository;
	
	@Override
	public void save(InterventionHistorique interventionHistorique) {
		interventionHistoriqueRepository.save(interventionHistorique);
	}

	@Override
	public List<InterventionHistorique> getAll() {
		return interventionHistoriqueRepository.findAll();
	}

	@Override
	public List<InterventionHistorique> getByInterventionId(Long interventionId ) {
		return interventionHistoriqueRepository.findByInterventionId(interventionId);
	}

}
