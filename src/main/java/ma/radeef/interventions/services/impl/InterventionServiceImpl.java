package ma.radeef.interventions.services.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.dao.EquipeRepository;
import ma.radeef.interventions.dao.InterventionHistRepository;
import ma.radeef.interventions.dao.InterventionRepository;
import ma.radeef.interventions.dao.TechnicienEquipeRepository;
import ma.radeef.interventions.endpoints.dtos.TechnicienDto;
import ma.radeef.interventions.endpoints.dtos.mappers.InterventionHistoriqueMapper;
import ma.radeef.interventions.models.Equipe;
import ma.radeef.interventions.models.Intervention;
import ma.radeef.interventions.models.InterventionHist;
import ma.radeef.interventions.models.InterventionStatut;
import ma.radeef.interventions.models.ReclamationStatut;
import ma.radeef.interventions.models.TechnicienEquipe;
import ma.radeef.interventions.models.User;
import ma.radeef.interventions.services.InterventionService;
import ma.radeef.interventions.services.ReclamationService;
import ma.radeef.interventions.services.UserHistService;
import ma.radeef.interventions.services.utils.GestionHistorique;

@Service
@RequiredArgsConstructor
public class InterventionServiceImpl implements InterventionService{
	
	private final InterventionRepository interventionRepository;
	private final InterventionHistoriqueMapper interventionHistoriqueMapper;
	private final InterventionHistRepository interventionHistRepository;
	private final EquipeRepository equipeRepository;
	private final UserHistService userHistService;
	private final ReclamationService reclamationService;
	private final TechnicienEquipeRepository technicienEquipeRepository;
	
	@Override
    public void save(Intervention intervention,List<TechnicienDto> techniciens, Long userId,  HttpServletRequest request) {
		
		if (intervention.getStatus() == null) {
            intervention.setStatus("En cours");
        }
		
		if(intervention.getTechnicien() == null && intervention.getEquipe() != null) {
			
			intervention.getEquipe().setActive(true);
			
			Equipe equipe = equipeRepository.save(intervention.getEquipe());

			intervention.setEquipe(equipe);	
			Intervention intervention_1 = interventionRepository.save(intervention);

			equipe.setIntervention_id(intervention_1.getId());;
			equipeRepository.save(equipe);
			
			for (TechnicienDto technicienDTO : techniciens) {
		       TechnicienEquipe technicienEquipe = new TechnicienEquipe();
		       User technicien = new User();
		       technicien.setId(technicienDTO.getUserId());
		          
		      technicienEquipe.setEquipe(equipe);
		      technicienEquipe.setTechnicien(technicien);
		      technicienEquipeRepository.save(technicienEquipe);
		      
		      reclamationService.updateReclamationStatus(intervention_1.getReclamation(), "En cours");
		      InterventionHist interventionHist = interventionHistoriqueMapper.toHistorique(intervention_1);
		      interventionHistRepository.save(interventionHist);
		      GestionHistorique.createIntervention(userHistService, intervention_1, userId, request);

            }
			
		}else {
						
			Intervention intervention_1 = interventionRepository.save(intervention);
		    reclamationService.updateReclamationStatus(intervention_1.getReclamation(), "En cours");
		    InterventionHist interventionHist = interventionHistoriqueMapper.toHistorique(intervention_1);
		    interventionHistRepository.save(interventionHist);
		    GestionHistorique.createIntervention(userHistService, intervention_1, userId, request);
		}
		
		
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
	public Intervention updateIntervention(Intervention newIntervention, List<TechnicienDto> techniciens, Long userId, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		Intervention oldIntervention = interventionRepository.findById(newIntervention.getId()).orElse(null);
        GestionHistorique.updateIntervention(userHistService, oldIntervention, newIntervention, userId, request);
        
        if(newIntervention.getStatus() == "Terminee") {
		    reclamationService.updateReclamationStatus(newIntervention.getReclamation(), "Terminee");
        }
        
		if(newIntervention.getTechnicien() == null && newIntervention.getEquipe() != null) {
			
			newIntervention.getEquipe().setActive(true);
			Equipe equipe = equipeRepository.save(newIntervention.getEquipe());
			
			newIntervention.setEquipe(equipe);	
			Intervention intervention_1 = interventionRepository.save(newIntervention);

			equipe.setIntervention_id(intervention_1.getId());;
			equipeRepository.save(equipe);
			
			for (TechnicienDto technicienDTO : techniciens) {
		       TechnicienEquipe technicienEquipe = new TechnicienEquipe();
		       User technicien = new User();
		       technicien.setId(technicienDTO.getUserId());
		          
		      technicienEquipe.setEquipe(equipe);
		      technicienEquipe.setTechnicien(technicien);
		      technicienEquipeRepository.save(technicienEquipe);   
            }
			
			return intervention_1;
			
		}else {
						
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
	public Intervention getByReclamationIdFonctionnel(String idFonctionnel) {
		// TODO Auto-generated method stub
		return interventionRepository.findByReclamationIdFonctionnel(idFonctionnel).orElse(null);
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

	
}
