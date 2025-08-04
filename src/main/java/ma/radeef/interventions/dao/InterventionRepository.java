package ma.radeef.interventions.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ma.radeef.interventions.models.Intervention;

@Repository
public interface InterventionRepository extends CrudRepository<Intervention, Long> {
	
	List<Intervention> findAll();
	
	List<Intervention> findByServiceId(Long serviceId);
	
	List<Intervention> findByDepartementId(Long departementId);
	
	List<Intervention> findByTechnicienId(Long technicienId);
	
	Optional<Intervention> findByReclamationIdFonctionnel(String idFonctionnel);

}
