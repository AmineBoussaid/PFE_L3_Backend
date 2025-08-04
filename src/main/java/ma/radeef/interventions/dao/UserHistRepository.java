
package ma.radeef.interventions.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ma.radeef.interventions.models.UserHist;

@Repository
public interface UserHistRepository extends CrudRepository<UserHist, Long> {
	
	List<UserHist> findAll();

	List<UserHist> findByUserId(Long userId);

}
