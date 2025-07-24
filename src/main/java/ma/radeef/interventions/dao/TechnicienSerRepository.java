package ma.radeef.interventions.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ma.radeef.interventions.models.TechnicienSer;

public interface TechnicienSerRepository extends CrudRepository<TechnicienSer, Long> {

	List<TechnicienSer> findAll();
	
}
