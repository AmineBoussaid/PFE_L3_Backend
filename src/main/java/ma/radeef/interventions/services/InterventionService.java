package ma.radeef.interventions.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import ma.radeef.interventions.endpoints.dtos.TechnicienDto;
import ma.radeef.interventions.models.Intervention;

@Service
public interface InterventionService {
	
	void save(Intervention intervention, List<TechnicienDto> techniciens, Long userId, HttpServletRequest request);
	
	Intervention getById(Long id);
	
	List<Intervention> getAll();
	
	/* lister par ServiceId*/
	List<Intervention> getByServiceId(Long serviceId);
	
	/* lister par DepartementId*/
	List<Intervention> getByDepartementId(Long departementId);
	
	/* lister par TechnicienId*/
	List<Intervention> getByTechnicienId(Long technicienId);
	
    /* delete par id */
    public boolean deleteById(Long id, Long userId, HttpServletRequest request);
    
    Intervention updateIntervention(Intervention intervention, List<TechnicienDto> techniciens, Long userId, HttpServletRequest request);
    
	/* lister par IdFonctionnel*/
    Intervention getByReclamationIdFonctionnel(String idFonctionnel);
    
    List<Intervention> getByCreateurId(Long createurId);
    
    List<LocalDate> getListDate(Long technicienI);

}
