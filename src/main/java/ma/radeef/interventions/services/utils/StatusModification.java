package ma.radeef.interventions.services.utils;


import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.dao.ReclamationRepository;
import ma.radeef.interventions.models.Intervention;
import ma.radeef.interventions.models.Reclamation;

@Service
@RequiredArgsConstructor
public class StatusModification {
	
    private static ReclamationRepository reclamationRepository;

    public static void updateReclamationStatus(Intervention intervention) {
        if (intervention.getReclamation() != null) {
            Reclamation reclamation = intervention.getReclamation();
            reclamation.setStatus(intervention.getStatus());
            reclamationRepository.save(reclamation);
        }
    }

}
