package ma.radeef.interventions.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ma.radeef.interventions.models.Equipe;

@Repository
public interface EquipeRepository extends CrudRepository<Equipe, Long> {
	
	List<Equipe> findAll();

}
