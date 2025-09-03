package ma.radeef.interventions.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.radeef.interventions.models.Intervention;

@Repository
public interface InterventionRepository extends JpaRepository<Intervention, Long> {
	
	List<Intervention> findByServiceId(Long serviceId);
	
	List<Intervention> findByDepartementId(Long departementId);
	
	List<Intervention> findByTechnicienId(Long technicienId);
	
	@Query(nativeQuery = true, value =  "SELECT i.* FROM intervention i"
			+ " left JOIN equipe e ON i.equipe_id = e.id"
			+ " left JOIN technicien_equipe t ON t.equipe_id = e.id"
			+ " WHERE e.chef_equipe_id = :technicienId OR t.technicien_id = :technicienId OR i.technicien_id = :technicienId"
			+ " GROUP BY (i.id)")
		List<Intervention> findByChefOrTechnicien(@Param("technicienId") Long technicienId);

	Optional<Intervention> findByReclamationIdFonctionnel(String idFonctionnel);
	
	List<Intervention> findByCreateurId(Long createurId);
	
}
