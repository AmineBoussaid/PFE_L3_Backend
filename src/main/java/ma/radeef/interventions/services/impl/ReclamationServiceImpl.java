package ma.radeef.interventions.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.dao.ClientRepository;
import ma.radeef.interventions.dao.ReclamationRepository;
import ma.radeef.interventions.models.Client;
import ma.radeef.interventions.models.Reclamation;
import ma.radeef.interventions.models.ReclamationStatut;
import ma.radeef.interventions.services.ReclamationService;
import ma.radeef.interventions.services.UserHistService;
import ma.radeef.interventions.services.utils.CopieAdresse;
import ma.radeef.interventions.services.utils.GestionHistorique;
import ma.radeef.interventions.services.utils.IdFonctionnelCalculator;

@Service
@RequiredArgsConstructor
public class ReclamationServiceImpl implements ReclamationService {

	private final ReclamationRepository reclamationRepository;

	private final UserHistService userHistService;
	private final ClientRepository clientRepository;

	@Override
	public void save(Reclamation reclamation, Long userId, HttpServletRequest request) {

		if (reclamation.getCodeAbonnement() != null) {
			Client client = clientRepository.findByCodeAbonnement(reclamation.getCodeAbonnement());
			reclamation = CopieAdresse.copie(client, reclamation);
		}

		if (reclamation.getIdFonctionnel() == null) {
			var random = IdFonctionnelCalculator.create();
			reclamation.setIdFonctionnel(random);
		}

		if (reclamation.getStatus() == null) {
			reclamation.setStatus("En attente");
		}

		GestionHistorique.createReclamation(userHistService, reclamation, userId, request);
		reclamationRepository.save(reclamation);
	}

	@Override
	public Reclamation updateReclamation(Reclamation newReclamation, Long userId, HttpServletRequest request) {
		Reclamation oldReclamation = reclamationRepository.findById(newReclamation.getId()).orElse(null);
		GestionHistorique.updateReclamation(userHistService, oldReclamation, newReclamation, userId, request);

		return reclamationRepository.save(newReclamation);
	}

	@Override
	public boolean deleteById(Long id, Long userId, HttpServletRequest request) {
		if (reclamationRepository.existsById(id)) {
			Reclamation reclamation = reclamationRepository.findById(id).orElse(null);
			GestionHistorique.deleteReclamation(userHistService, reclamation, userId, request);

			reclamationRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
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

	@Override
	public List<Reclamation> getByNomClient(String nomClient) {
		// TODO Auto-generated method stub
		return reclamationRepository.findByNomClient(nomClient);
	}

	@Override
	public List<Reclamation> getByAgentId(Long agentId) {
		// TODO Auto-generated method stub
		return reclamationRepository.findByAgentId(agentId);
	}

	@Override
	public List<Reclamation> getByServiceId(Long serviceId) {
		// TODO Auto-generated method stub
		return reclamationRepository.findByServiceId(serviceId);
	}

	@Override
	public List<Reclamation> getByDepartementId(Long departementId) {
		// TODO Auto-generated method stub
		return reclamationRepository.findByDepartementId(departementId);
	}

	@Override
	public Reclamation updateReclamationStatus(Reclamation reclamation, String reclamationStatut) {
		reclamation.setStatus(reclamationStatut);
		return reclamationRepository.save(reclamation);
	}

}
