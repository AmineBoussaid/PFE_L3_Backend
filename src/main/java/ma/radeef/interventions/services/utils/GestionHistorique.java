package ma.radeef.interventions.services.utils;

import java.util.Objects;

import ma.radeef.interventions.models.Intervention;
import ma.radeef.interventions.models.Reclamation;
import ma.radeef.interventions.models.User;
import ma.radeef.interventions.services.UserHistoriqueService;

public class GestionHistorique {
	
    static User user = new User();
	
    public static void createReclamation(UserHistoriqueService userHistoriqueService, Reclamation reclamation ,Long userId) {
        String action = "Creation";
        String details = "Reclamation N°: " + reclamation.getIdFonctionnel() + " crée";
              
        user.setId(userId);
        userHistoriqueService.save(user, action, details);
    }
    
    public static void updateReclamation(UserHistoriqueService userHistoriqueService, Reclamation oldReclamation, Reclamation newReclamation, Long userId) {
        String action = "Modification";
              
        
        String details = "Reclamation N°: " + oldReclamation.getIdFonctionnel() + " modifiée. ";  
        if (!Objects.equals(oldReclamation.getNomClient(), newReclamation.getNomClient()))
        {
        	details += "Nom Client modifié de "+ oldReclamation.getNomClient() + " à " + newReclamation.getNomClient() + " . " ;
        }
        if (!Objects.equals(oldReclamation.getTelephone(), newReclamation.getTelephone()))
        {
        	details += "Telephone modifié de "+ oldReclamation.getTelephone() + " à " + newReclamation.getTelephone() + " . " ;
        }
        if (!Objects.equals(oldReclamation.getEmail(), newReclamation.getEmail()))
        {
        	details += "Email modifié de "+ oldReclamation.getEmail() + " à " + newReclamation.getEmail() + " . " ;
        }
        if (!Objects.equals(oldReclamation.getQuartier(), newReclamation.getQuartier()))
        {
        	details += "Quartier modifié de "+ oldReclamation.getQuartier() + " à " + newReclamation.getQuartier() + " . " ;
        }
        if (!Objects.equals(oldReclamation.getNomRue(), newReclamation.getNomRue()))
        {
        	details += "NomRue modifié de "+ oldReclamation.getNomRue() + " à " + newReclamation.getNomRue() + " . " ;
        }
        if (!Objects.equals(oldReclamation.getCategory(), newReclamation.getCategory()))
        {
        	details += "Category modifié de "+ oldReclamation.getCategory() + " à " + newReclamation.getCategory() + " . " ;
        }
        if (!Objects.equals(oldReclamation.getSituation(), newReclamation.getSituation()))
        {
        	details += "Situation modifié de "+ oldReclamation.getSituation() + " à " + newReclamation.getSituation() + " . " ;
        }
        if (!Objects.equals(oldReclamation.getPeriode(), newReclamation.getPeriode()))
        {
        	details += "Periode modifié de "+ oldReclamation.getPeriode() + " à " + newReclamation.getPeriode() + " . " ;
        }
        if (!Objects.equals(oldReclamation.getOccurrence(), newReclamation.getOccurrence()))
        {
        	details += "Occurrence modifié de "+ oldReclamation.getOccurrence() + " à " + newReclamation.getOccurrence() + " . " ;
        }
        if (!Objects.equals(oldReclamation.getService().getId(), newReclamation.getService().getId()))
        {
        	details += "Service modifié de "+ oldReclamation.getService().getNom() + " à " + newReclamation.getService().getNom() + " . " ;
        }
        
        user.setId(userId);
        userHistoriqueService.save(user, action, details);
    }

    public static void deleteReclamation(UserHistoriqueService userHistoriqueService, Reclamation reclamation, Long userId) {
        String action = "Supression";
        String details = "Reclamation N°: " + reclamation.getIdFonctionnel() + " suprimée. ";
        
        user.setId(userId);
        userHistoriqueService.save(user, action, details);
    }


    public static void createIntervention(UserHistoriqueService userHistoriqueService, Intervention intervention ,Long userId) {
        String action = "Creation";
        String details = "Intervention N°: " + intervention.getReclamation().getIdFonctionnel() + " crée";

        user.setId(userId);
        userHistoriqueService.save(user, action, details);
    }

    public static void updateIntervention(UserHistoriqueService userHistoriqueService, Intervention oldIntervention, Intervention newIntervention, Long userId) {
        String action = "Modification";
        
              
        String details = "Intervention N°: " + oldIntervention.getReclamation().getIdFonctionnel() + " modifiée. ";  
        if (!Objects.equals(oldIntervention.getTitre(), newIntervention.getTitre()))
        {
        	details += "Titre modifié de "+ oldIntervention.getTitre() + " à " + newIntervention.getTitre() + " . " ;
        }
        if (!Objects.equals(oldIntervention.getDateDebut(), newIntervention.getDateDebut()))
        {
        	details += "Date Debut modifié de "+ oldIntervention.getDateDebut() + " à " + newIntervention.getDateDebut() + " . " ;
        }
        if (!Objects.equals(oldIntervention.getDateFin(), newIntervention.getDateFin()))
        {
        	details += "Date Fin modifié de "+ oldIntervention.getDateFin() + " à " + newIntervention.getDateFin() + " . " ;
        }
        if (!Objects.equals(oldIntervention.getDepartement().getId(), newIntervention.getDepartement().getId()))
        {
        	details += "Departement modifié de "+ oldIntervention.getDepartement().getNom() + " à " + newIntervention.getDepartement().getNom() + " . " ;
        }
        if (!Objects.equals(oldIntervention.getService().getId(), newIntervention.getService().getId()))
        {
        	details += "Service modifié de "+ oldIntervention.getService().getNom() + " à " + newIntervention.getService().getNom() + " . " ;
        }

        if (oldIntervention.getEquipe() != null && newIntervention.getEquipe() == null && oldIntervention.getTechnicien() == null && newIntervention.getTechnicien() != null )
        {
            	details += "Changement de Equipe à Technicien" ;
        }
        if (oldIntervention.getTechnicien() != null && newIntervention.getTechnicien() == null && oldIntervention.getEquipe() == null && newIntervention.getEquipe() != null )
        {
            	details += "Changement de Technicien à Equipe" ;
        }
        
        user.setId(userId);
        userHistoriqueService.save(user, action, details);
    }

    
    public static void deleteIntervention(UserHistoriqueService userHistoriqueService, Intervention Intervention , Long userId) {
        String action = "Supression";
        String details = "Intervention N°: " + Intervention.getReclamation().getIdFonctionnel() + " suprimée. ";
        
        user.setId(userId);
        userHistoriqueService.save(user, action, details);
    }

	public static void loginUser(UserHistoriqueService userHistoriqueService, User user) {
		String action = "Login";
	    String details = "Login d'Utilisateur: " + user.getUsername() ;
	    
	    
	    userHistoriqueService.save(user, action, details);
	}
	
	public static void logoutUser(UserHistoriqueService userHistoriqueService, User user) {
		String action = "Logout";
	    String details = "Logout d'Utilisateur: " + user.getUsername() ;
	    
	    userHistoriqueService.save(user, action, details);
	}

}