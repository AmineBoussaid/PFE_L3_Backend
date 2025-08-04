package ma.radeef.interventions.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.dao.InterventionHistRepository;
import ma.radeef.interventions.dao.InterventionRepository;
import ma.radeef.interventions.endpoints.dtos.mappers.InterventionDtoMapper;
import ma.radeef.interventions.models.Intervention;
import ma.radeef.interventions.models.InterventionHist;
import ma.radeef.interventions.models.Reclamation;
import ma.radeef.interventions.services.InterventionService;
import ma.radeef.interventions.services.UserHistService;
import ma.radeef.interventions.services.utils.GestionHistorique;
import ma.radeef.interventions.services.utils.StatusModification;

@Service
@RequiredArgsConstructor
public class InterventionServiceImpl implements InterventionService{
	
	private final InterventionRepository interventionRepository;
	private final InterventionDtoMapper interventionDtoMapper;
	private final InterventionHistRepository interventionHistRepository;
    private final StatusModification statusModification;
	private final UserHistService userHistService;

    

	
	@Override
    public void save(Intervention intervention, Long userId, HttpServletRequest request) {
		if (intervention.getStatus() == null) {
            intervention.setStatus("En cours");
        }
        /*statusModification.updateReclamationStatus(intervention);*/
        
        InterventionHist interventionHist = interventionDtoMapper.toDto(intervention);
        interventionHistRepository.save(interventionHist);
        
		GestionHistorique.createIntervention(userHistService, intervention, userId, request);
		
		interventionRepository.save(intervention);
    }
    
	@Override
	public boolean deleteById(Long id,Long userId, HttpServletRequest request) {
		// TODO Auto-generated method stub		
        if (interventionRepository.existsById(id)) {
    		Intervention intervention = interventionRepository.findById(id).orElse(null);
	        GestionHistorique.deleteIntervention(userHistService, intervention, userId, request);

        	interventionRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

	@Override
	public Intervention updateIntervention(Intervention newIntervention, Long userId, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Intervention oldIntervention = interventionRepository.findById(newIntervention.getId()).orElse(null);
        GestionHistorique.updateIntervention(userHistService, oldIntervention, newIntervention, userId,request);

		return interventionRepository.save(newIntervention);
	}

	@Override
	public Intervention getById(Long id) {
		// TODO Auto-generated method stub
		return interventionRepository.findById(id).orElse(null);
	}
	
	@Override
	public List<Intervention> getAll() {
		// TODO Auto-generated method stub
		return interventionRepository.findAll();
	}

	@Override
	public List<Intervention> getByServiceId(Long serviceId) {
		// TODO Auto-generated method stub
		return interventionRepository.findByServiceId(serviceId);
	}
	
	@Override
	public List<Intervention> getByDepartementId(Long departementId) {
		// TODO Auto-generated method stub
		return interventionRepository.findByDepartementId(departementId);
	}

	@Override
	public List<Intervention> getByTechnicienId(Long technicienId) {
		// TODO Auto-generated method stub
		return interventionRepository.findByTechnicienId(technicienId);
	}

	@Override
	public Intervention getByReclamationIdFonctionnel(String idFonctionnel) {
		// TODO Auto-generated method stub
		return interventionRepository.findByReclamationIdFonctionnel(idFonctionnel).orElse(null);
	}

	
}
