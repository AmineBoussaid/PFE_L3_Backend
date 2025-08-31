package ma.radeef.interventions.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.radeef.interventions.models.Reclamation;


@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {
	
	Optional<Reclamation> findByIdFonctionnel(String idFonctionnel);
		
	List<Reclamation> findByNomClient(String nomClient);
	
	List<Reclamation> findByAgentId(Long agentId);
	
	List<Reclamation> findByServiceId(Long serviceId);
	
	@Query("SELECT r FROM Reclamation r JOIN r.service s WHERE s.departement.id = :departementId")
	List<Reclamation> findByDepartementId(@Param("departementId") Long departementId);
    
    
}
