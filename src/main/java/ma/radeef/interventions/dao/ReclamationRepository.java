package ma.radeef.interventions.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.radeef.interventions.endpoints.dtos.ReclamationStatusCount;
import ma.radeef.interventions.models.Reclamation;


@Repository
public interface ReclamationRepository extends CrudRepository<Reclamation, Long> {
	
	Optional<Reclamation> findByIdFonctionnel(String idFonctionnel);
	
	List<Reclamation> findAll();
	
	List<Reclamation> findByNomClient(String nomClient);
	
	List<Reclamation> findByAgentId(Long agentId);
	
	List<Reclamation> findByServiceId(Long serviceId);
	
	@Query("SELECT r FROM Reclamation r JOIN r.service s WHERE s.departement.id = :departementId")
	List<Reclamation> findByDepartementId(@Param("departementId") Long departementId);

	
	/* count status Reclamation */
    @Query("SELECT new ma.radeef.interventions.endpoints.dtos.ReclamationStatusCount(r.status, COUNT(r)) FROM Reclamation r GROUP BY r.status")
    List<ReclamationStatusCount> countReclamationsByStatus();
    
    
}
