package ma.radeef.interventions.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ma.radeef.interventions.models.ServiceD;

@Repository
public interface ServiceDRepository extends CrudRepository<ServiceD, Long> {
	
	List<ServiceD> findAll();
	
	List<ServiceD> findByDepartementId(Long departementId);
	
	ServiceD findByChefServiceId(Long chefServiceId);

}
