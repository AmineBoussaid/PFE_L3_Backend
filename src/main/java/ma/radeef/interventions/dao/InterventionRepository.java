package ma.radeef.interventions.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ma.radeef.interventions.models.Intervention;

@Repository
public interface InterventionRepository extends CrudRepository<Intervention, Long> {
	
	List<Intervention> findAll();
	
	
}
