package ma.radeef.interventions.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.dao.InterventionHistRepository;
import ma.radeef.interventions.models.Intervention;
import ma.radeef.interventions.models.InterventionHist;
import ma.radeef.interventions.services.InterventionHistService;

@Service
@RequiredArgsConstructor
public class InterventionHistServiceImpl implements InterventionHistService{

	private final InterventionHistRepository interventionHistRepository;
	
	@Override
	public void save(InterventionHist interventionHist) {
		// TODO Auto-generated method stub
		interventionHistRepository.save(interventionHist);
	}

	@Override
	public List<InterventionHist> getAll() {
		// TODO Auto-generated method stub
		return interventionHistRepository.findAll();
	}

	@Override
	public List<InterventionHist> getByInterventionId(Long interventionId ) {
		// TODO Auto-generated method stub
		return interventionHistRepository.findByInterventionId(interventionId);
	}

}
