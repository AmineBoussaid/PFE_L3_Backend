package ma.radeef.interventions.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.models.Equipe;
import ma.radeef.interventions.repositories.EquipeRepository;
import ma.radeef.interventions.services.EquipeService;

@Service
@RequiredArgsConstructor
public class EquipeServiceImpl implements EquipeService {

	private final EquipeRepository equipeRepository;

	@Override
	public void save(Equipe equipe) {
		equipeRepository.save(equipe);
	}

	@Override
	public List<Equipe> getAll() {
		return equipeRepository.findAll();
	}

	@Override
	public boolean deleteById(Long id) {
		if (equipeRepository.existsById(id)) {
			equipeRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<Equipe> getByChefEquipeSericeServiceId(Long serviceId) {
		// TODO Auto-generated method stub
		return equipeRepository.findByChefEquipeServiceId(serviceId);
	}

}
