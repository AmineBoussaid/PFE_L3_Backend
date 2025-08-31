package ma.radeef.interventions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.radeef.interventions.models.ChefService;

@Repository
public interface ChefServiceRepository extends JpaRepository<ChefService, Long> {

}
