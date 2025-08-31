package ma.radeef.interventions.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.radeef.interventions.models.Equipe;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {
		
	List<Equipe> findByChefEquipeServiceId(Long serviceId);
	
}
