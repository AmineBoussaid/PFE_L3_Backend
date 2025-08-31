package ma.radeef.interventions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.radeef.interventions.models.Departement;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, Long> {
	
    Departement findByChefDepartementId(Long chefDepartementId);
    
}