package ma.radeef.interventions.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ma.radeef.interventions.models.Departement;

@Repository
public interface DepartementRepository extends CrudRepository<Departement, Long> {
	
	List<Departement> findAll();
	
    Departement findByChefDepartementId(Long chefDepartementId);
    
}