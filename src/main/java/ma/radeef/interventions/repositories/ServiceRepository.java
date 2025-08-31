package ma.radeef.interventions.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.radeef.interventions.models.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
	
	List<Service> findAll();
	
	List<Service> findByDepartementId(Long departementId);
	
	Service findByChefServiceId(Long chefServiceId);

}
