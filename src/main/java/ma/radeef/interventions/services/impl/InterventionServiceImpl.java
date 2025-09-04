package ma.radeef.interventions.services.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.endpoints.dtos.mappers.InterventionHistoriqueMapper;
import ma.radeef.interventions.models.Equipe;
import ma.radeef.interventions.models.Intervention;
import ma.radeef.interventions.models.InterventionHistorique;
import ma.radeef.interventions.repositories.EquipeRepository;
import ma.radeef.interventions.repositories.InterventionHistoriqueRepository;
import ma.radeef.interventions.repositories.InterventionRepository;
import ma.radeef.interventions.services.EquipeService;
import ma.radeef.interventions.services.InterventionService;
import ma.radeef.interventions.services.ReclamationService;
import ma.radeef.interventions.services.UserHistoriqueService;
import ma.radeef.interventions.services.utils.GestionHistorique;

@Service
@RequiredArgsConstructor
public class InterventionServiceImpl implements InterventionService {
	
	private final InterventionRepository interventionRepository;
	private final InterventionHistoriqueMapper interventionHistoriqueMapper;
	private final InterventionHistoriqueRepository interventionHistoriqueRepository;
	private final EquipeRepository equipeRepository;
	private final UserHistoriqueService userHistoriqueService;
	private final ReclamationService reclamationService;
	private final EquipeService equipeService;

	
	@Override
    public void add(Intervention intervention, Long userId) {
		
		if (intervention.getStatus() == null) {
            intervention.setStatus("En cours");
        }
		
		if(intervention.getTechnicien() == null && intervention.getEquipe() != null) {
			
			intervention.getEquipe().setActive(true);
			
			Equipe equipe = equipeRepository.save(intervention.getEquipe());

			intervention.setEquipe(equipe);	
			Intervention intervention1 = interventionRepository.save(intervention);

			equipe.setIntervention(intervention1);
			equipeRepository.save(equipe);
			

		    reclamationService.updateReclamationStatus(intervention1.getReclamation(), "En cours");
		    InterventionHistorique interventionHistorique = interventionHistoriqueMapper.toHistorique(intervention1);
		    interventionHistoriqueRepository.save(interventionHistorique);
		    GestionHistorique.createIntervention(userHistoriqueService, intervention1, userId);

			
		}else {
						
			Intervention intervention_1 = interventionRepository.save(intervention);
		    reclamationService.updateReclamationStatus(intervention_1.getReclamation(), "En cours");
		    InterventionHistorique interventionHistorique = interventionHistoriqueMapper.toHistorique(intervention_1);
		    interventionHistoriqueRepository.save(interventionHistorique);
		    GestionHistorique.createIntervention(userHistoriqueService, intervention_1, userId);
		}
		
		
	}
    
	@Override
	public boolean deleteById(Long id,Long userId) {
		// TODO Auto-generated method stub		
        if (interventionRepository.existsById(id)) {
        	
    		Intervention intervention = interventionRepository.findById(id).orElse(null);
	        GestionHistorique.deleteIntervention(userHistoriqueService, intervention, userId);
        	interventionRepository.deleteById(id);
            return true;
            
        } else {
            return false;
        }
    }

	@Override
	public Intervention updateIntervention(Intervention newIntervention,Long userId) {
		
		Intervention oldIntervention = interventionRepository.findById(newIntervention.getId()).orElse(null);
        GestionHistorique.updateIntervention(userHistoriqueService, oldIntervention, newIntervention, userId);
        
        if("Terminee".equals(newIntervention.getStatus())) {
            reclamationService.updateReclamationStatus(newIntervention.getReclamation(), "Terminee");
            if(newIntervention.getEquipe()!=null)
            {
    			Equipe equipe = newIntervention.getEquipe();;
    			equipe.setIntervention(newIntervention);
            	equipeService.updateEquipeActive(equipe);
            }

            
        }else if("Annulee".equals(newIntervention.getStatus())) {
            reclamationService.updateReclamationStatus(newIntervention.getReclamation(), "Annulee");
            if(newIntervention.getEquipe()!=null)
            {
    			Equipe equipe = newIntervention.getEquipe();;
    			equipe.setIntervention(newIntervention);
            	equipeService.updateEquipeActive(equipe);
            }
        }
        
		if((newIntervention.getTechnicien() == null && newIntervention.getEquipe() != null) &&
				(oldIntervention.getTechnicien() != null && oldIntervention.getEquipe() == null )) {
			
			newIntervention.getEquipe().setActive(true);
			Equipe equipe = equipeRepository.save(newIntervention.getEquipe());
			
			newIntervention.setEquipe(equipe);	
			Intervention intervention1 = interventionRepository.save(newIntervention);

			equipe.setIntervention(intervention1);
			equipeRepository.save(equipe);
			
		    InterventionHistorique interventionHistorique = interventionHistoriqueMapper.toHistorique(intervention1);
		    interventionHistoriqueRepository.save(interventionHistorique);
			return intervention1;
			
		}else {
			
		    InterventionHistorique interventionHistorique = interventionHistoriqueMapper.toHistorique(newIntervention);
		    interventionHistoriqueRepository.save(interventionHistorique);
			return interventionRepository.save(newIntervention);
		}

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
	public Optional<Intervention> getByReclamationIdFonctionnel(String idFonctionnel) {
		// TODO Auto-generated method stub
		return interventionRepository.findByReclamationIdFonctionnel(idFonctionnel);
	}

	@Override
	public List<Intervention> getByCreateurId(Long createurId) {
		// TODO Auto-generated method stub
		return interventionRepository.findByCreateurId(createurId);
	}

	@Override
	public List<LocalDate> getListDate(Long technicienId) {
	    List<Intervention> interventions = interventionRepository.findByTechnicienId(technicienId);
	    
	    List<LocalDate> dates = new ArrayList<>();
	    
	    for (Intervention intervention : interventions) {
	        LocalDate startDate = intervention.getDateDebut().toLocalDate();
	        LocalDate endDate = intervention.getDateFin().toLocalDate();
	        
	        dates.add(startDate);

	        while (startDate.isBefore(endDate)) {
	            startDate = startDate.plusDays(1);
	            dates.add(startDate);
	        }
	    }
	    return dates;
	}

	@Override
	public List<Intervention> getByChefOrTechnicien(Long technicienId) {
		// TODO Auto-generated method stub
		return interventionRepository.findByChefOrTechnicien(technicienId);
	}

	
}
