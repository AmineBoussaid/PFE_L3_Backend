package ma.radeef.interventions.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.radeef.interventions.models.Departement;

@Repository
public interface DepartementRepository extends CrudRepository<Departement, Long> {
	
	List<Departement> findAll();
	
    @Query("SELECT d.id FROM Departement d WHERE d.chefDepartement.id = :chefDepartementId")
    Long findByChefDepartementId(@Param("chefDepartementId") Long chefDepartementId);
    
}