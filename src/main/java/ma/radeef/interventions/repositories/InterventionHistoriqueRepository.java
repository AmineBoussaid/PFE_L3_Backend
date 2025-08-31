package ma.radeef.interventions.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.radeef.interventions.models.InterventionHistorique;

@Repository
public interface InterventionHistoriqueRepository extends JpaRepository<InterventionHistorique, Long>{
		
	List<InterventionHistorique> findByInterventionId(Long interventionId);

}
