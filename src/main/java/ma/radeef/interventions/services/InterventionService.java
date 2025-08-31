package ma.radeef.interventions.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ma.radeef.interventions.models.Intervention;
import ma.radeef.interventions.models.Technicien;

@Service
public interface InterventionService {
	
	void add(Intervention intervention, Long userId);
	
	Intervention getById(Long id);
	
	List<Intervention> getAll();
	
	List<Intervention> getByServiceId(Long serviceId);
	
	List<Intervention> getByDepartementId(Long departementId);
	
	List<Intervention> getByTechnicienId(Long technicienId);
	
    boolean deleteById(Long id, Long userId);
    
    Intervention updateIntervention(Intervention intervention, Long userId);
    
    Optional<Intervention> getByReclamationIdFonctionnel(String idFonctionnel);
    
    List<Intervention> getByCreateurId(Long createurId);
    
    List<LocalDate> getListDate(Long technicienI);
    
    List<Intervention> getByChefOrTechnicien(Long technicienId);

}
