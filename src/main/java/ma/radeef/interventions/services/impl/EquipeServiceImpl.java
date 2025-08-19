package ma.radeef.interventions.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.dao.EquipeRepository;
import ma.radeef.interventions.models.Equipe;
import ma.radeef.interventions.services.EquipeService;

@Service
@RequiredArgsConstructor
public class EquipeServiceImpl implements EquipeService{
	
	
	private final EquipeRepository equipeRepository;
	private final TechnicienEquipeServiceImpl technicienEquipeServiceImpl;
	
	@Override
	public void save(Equipe equipe) {
		// TODO Auto-generated method stub
		
		equipeRepository.save(equipe);
	}

	@Override
	public List<Equipe> getAll() {
		// TODO Auto-generated method stub
		return equipeRepository.findAll();
	}

	@Override
	public boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		if( equipeRepository.existsById(id)) {
			technicienEquipeServiceImpl.deleteByEquipeId(id);
			equipeRepository.deleteById(id);
			return true;
		}
		return false;
	}
	

}
