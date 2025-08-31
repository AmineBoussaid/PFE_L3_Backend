package ma.radeef.interventions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.radeef.interventions.models.ChefDepartement;

@Repository
public interface ChefDepartementRepository extends JpaRepository<ChefDepartement, Long> {

}
