package ma.radeef.interventions.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.dao.ReclamationRepository;
import ma.radeef.interventions.models.Reclamation;
import ma.radeef.interventions.services.ReclamationService;
import ma.radeef.interventions.services.utils.IdFonctionnelCalculator;

@Service
@RequiredArgsConstructor
public class ReclamationServiceImpl implements ReclamationService {
	
	private final ReclamationRepository reclamationRepository;

	@Override
	public void save(Reclamation reclamation) {
		if(reclamation.getIdFonctionnel() == null) {
			var random = IdFonctionnelCalculator.create();
			reclamation.setIdFonctionnel(random);
		}
		reclamationRepository.save(reclamation);
	}

	@Override
	public Reclamation getById(Long id) {
		return reclamationRepository.findById(id).orElse(null);

	}

	@Override
	public Reclamation getByIdFonctionnel(String idFonctionnel) {
		return reclamationRepository.findByIdFonctionnel(idFonctionnel).orElse(null);
	}

	@Override
	public List<Reclamation> getAll() {
		return reclamationRepository.findAll();
	}

	
}
