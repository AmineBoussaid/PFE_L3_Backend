package ma.radeef.interventions.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.models.Client;
import ma.radeef.interventions.models.Reclamation;
import ma.radeef.interventions.repositories.ClientRepository;
import ma.radeef.interventions.repositories.ReclamationRepository;
import ma.radeef.interventions.services.ReclamationService;
import ma.radeef.interventions.services.UserHistoriqueService;
import ma.radeef.interventions.services.utils.CopieAdresse;
import ma.radeef.interventions.services.utils.GestionHistorique;
import ma.radeef.interventions.services.utils.IdFonctionnelCalculator;

@Service
@RequiredArgsConstructor
public class ReclamationServiceImpl implements ReclamationService {

	private final ReclamationRepository reclamationRepository;

	private final UserHistoriqueService userHistoriqueService;
	private final ClientRepository clientRepository;

	@Override
	public String save(Reclamation reclamation, Long userId) {

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

		GestionHistorique.createReclamation(userHistoriqueService, reclamation, userId);
        // Enregistrez la réclamation dans la base de données
        Reclamation savedReclamation = reclamationRepository.save(reclamation);
        
        // Retournez l'ID fonctionnel après l'enregistrement
        return savedReclamation.getIdFonctionnel();
	}

	@Override
	public Reclamation updateReclamation(Reclamation newReclamation, Long userId) {
		Reclamation oldReclamation = reclamationRepository.findById(newReclamation.getId()).orElse(null);
		GestionHistorique.updateReclamation(userHistoriqueService, oldReclamation, newReclamation, userId);

		return reclamationRepository.save(newReclamation);
	}

	@Override
	public boolean deleteById(Long id, Long userId) {
		if (reclamationRepository.existsById(id)) {
			Reclamation reclamation = reclamationRepository.findById(id).orElse(null);
			GestionHistorique.deleteReclamation(userHistoriqueService, reclamation, userId);

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
