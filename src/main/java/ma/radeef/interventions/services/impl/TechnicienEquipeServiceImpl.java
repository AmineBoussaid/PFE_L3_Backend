package ma.radeef.interventions.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.dao.TechnicienEquipeRepository;
import ma.radeef.interventions.models.TechnicienEquipe;
import ma.radeef.interventions.services.TechnicienEquipeService;

@Service
@RequiredArgsConstructor
public class TechnicienEquipeServiceImpl implements TechnicienEquipeService {
	
	private final TechnicienEquipeRepository technicienEquipeRepository;
	
	@Override
	public void save(TechnicienEquipe technicienEquipe) {
		technicienEquipeRepository.save(technicienEquipe);
	}

	@Override
	public List<TechnicienEquipe> getAll() {
		return technicienEquipeRepository.findAll();
	}

	@Override
	public boolean deleteByTechnicienEquipe(Long technicienId, Long equipeId) {
		TechnicienEquipe technicienEquipe =  technicienEquipeRepository.findByTechnicienIdAndEquipeId(technicienId, equipeId);
		if(technicienEquipe != null) {
			technicienEquipeRepository.deleteById(technicienEquipe.getId());
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteByEquipeId(Long equipeId) {
		List<TechnicienEquipe> techniciensEquipe =  technicienEquipeRepository.findByEquipeId(equipeId);
		if(techniciensEquipe != null) {
			for (TechnicienEquipe technicienEquipe : techniciensEquipe) {
				technicienEquipeRepository.deleteById(technicienEquipe.getId());
			}
			return true;
		}
		return false;
	}
}
