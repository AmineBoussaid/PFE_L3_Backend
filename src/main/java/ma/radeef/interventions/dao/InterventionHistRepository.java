package ma.radeef.interventions.dao;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ma.radeef.interventions.models.InterventionHist;

@Repository
public interface InterventionHistRepository extends CrudRepository<InterventionHist, Long>{
	
	List<InterventionHist> findAll();
	
	List<InterventionHist> findByInterventionId(Long interventionId);

}
