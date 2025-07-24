package ma.radeef.interventions.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.radeef.interventions.models.ServiceD;

@Repository
public interface ServiceDRepository extends CrudRepository<ServiceD, Long> {
	
	List<ServiceD> findAll();
	
	List<ServiceD> findByDepartementId(Long departementId);
	
	@Query("SELECT s.id FROM service s WHERE s.chefService.id = :chefServiceId")
    Long findByChefServiceId(@Param("chefServiceId") Long chefServiceId);

}
