package ma.radeef.interventions.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.radeef.interventions.endpoints.dtos.TechnicienDto;
import ma.radeef.interventions.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	List<User> findAll();

    @Query("SELECT new ma.radeef.interventions.endpoints.dtos.TechnicienDto(u.id, u.username, u.email, u.role, s.id, s.nom) " +
            "FROM User u " +
            "JOIN u.technicienServices ts " +
            "JOIN ts.service s " +
            "WHERE u.role = 'technicien' AND s.id = :serviceId")
     List<TechnicienDto> findTechniciensByServiceId(@Param("serviceId") Long serviceId);
}
