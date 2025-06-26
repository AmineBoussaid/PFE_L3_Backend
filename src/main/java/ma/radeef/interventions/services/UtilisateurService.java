package ma.radeef.interventions.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ma.radeef.interventions.models.Utilisateur;

@Service
public interface UtilisateurService {

	List<Utilisateur> getAll();	
}
