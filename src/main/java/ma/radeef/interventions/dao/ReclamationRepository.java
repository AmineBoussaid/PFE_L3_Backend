package ma.radeef.interventions.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ma.radeef.interventions.models.Reclamation;


@Repository
public interface ReclamationRepository extends CrudRepository<Reclamation, Long> {
	
	Optional<Reclamation> findByIdFonctionnel(String idFonctionnel);
	
	
	List<Reclamation> findAll();
}
