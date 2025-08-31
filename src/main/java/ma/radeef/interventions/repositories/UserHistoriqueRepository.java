
package ma.radeef.interventions.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.radeef.interventions.models.UserHistorique;

@Repository
public interface UserHistoriqueRepository extends JpaRepository<UserHistorique, Long> {

	List<UserHistorique> findByUserId(Long userId);

}
