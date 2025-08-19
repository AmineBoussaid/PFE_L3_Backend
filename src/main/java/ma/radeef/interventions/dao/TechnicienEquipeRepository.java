package ma.radeef.interventions.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ma.radeef.interventions.models.TechnicienEquipe;

public interface TechnicienEquipeRepository extends CrudRepository<TechnicienEquipe, Long>{
	
	List<TechnicienEquipe> findAll();
	
	TechnicienEquipe findByTechnicienId(Long technicienId);
	
	List<TechnicienEquipe> findByEquipeId(Long technicienId);
	
	TechnicienEquipe findByTechnicienIdAndEquipeId(Long technicienId, Long equipeId);
		
	boolean deleteByEquipeId(Long equipeId);


}
