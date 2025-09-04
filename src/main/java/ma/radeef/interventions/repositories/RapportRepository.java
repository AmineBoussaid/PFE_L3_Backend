package ma.radeef.interventions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.radeef.interventions.models.Rapport;

public interface RapportRepository  extends JpaRepository<Rapport, Long>{

	Rapport findByInterventionId(Long interventionId );
}
