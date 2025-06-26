package ma.radeef.interventions.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import ma.radeef.interventions.models.Utilisateur;

@Repository
public interface UtilisateurDao {
	
	List<Utilisateur> findAll();
	
}
