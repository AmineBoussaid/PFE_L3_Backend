package ma.radeef.interventions.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ma.radeef.interventions.models.Technicien;

@Repository
public interface TechnicienRepository extends JpaRepository<Technicien, Long> {
	
	List<Technicien> findByServiceId(Long serviceId);
	
}
