package ma.radeef.interventions.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.radeef.interventions.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
		
    Optional<User> findByEmail(String email);

	Optional<User> findByUsername(String username);
       
}
