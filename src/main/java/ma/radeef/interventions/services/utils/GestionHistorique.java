package ma.radeef.interventions.services.utils;

import java.util.Objects;

import jakarta.servlet.http.HttpServletRequest;
import ma.radeef.interventions.models.Intervention;
import ma.radeef.interventions.models.Reclamation;
import ma.radeef.interventions.models.User;
import ma.radeef.interventions.services.UserHistService;

public class GestionHistorique {
	
    static User user = new User();
	
    public static void createReclamation(UserHistService userHistService, Reclamation reclamation ,Long userId, HttpServletRequest request) {
        String action = "Creation";
        String details = "Reclamation N°: " + reclamation.getIdFonctionnel() + " crée";
        
        // Récupérer l'adresse IP réelle du client
        String ip_address = request.getHeader("X-Forwarded-For");
        if (ip_address == null || ip_address.isEmpty()) {
        	ip_address = request.getRemoteAddr();
        }        
        user.setId(userId);
        userHistService.save(user, action, details, ip_address);
    }
    
    public static void updateReclamation(UserHistService userHistService, Reclamation oldReclamation, Reclamation newReclamation, Long userId, HttpServletRequest request) {
        String action = "Modification";
        
        // Récupérer l'adresse IP réelle du client
        String ip_address = request.getHeader("X-Forwarded-For");
        if (ip_address == null || ip_address.isEmpty()) {
        	ip_address = request.getRemoteAddr();
        }         
        
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
        userHistService.save(user, action, details, ip_address);
    }

    public static void deleteReclamation(UserHistService userHistService, Reclamation reclamation, Long userId, HttpServletRequest request) {
        String action = "Supression";
        String details = "Reclamation N°: " + reclamation.getIdFonctionnel() + " suprimée. ";
        
        // Récupérer l'adresse IP réelle du client
        String ip_address = request.getHeader("X-Forwarded-For");
        if (ip_address == null || ip_address.isEmpty()) {
        	ip_address = request.getRemoteAddr();
        }  
        
        user.setId(userId);
        userHistService.save(user, action, details, ip_address);
    }


    public static void createIntervention(UserHistService userHistService, Intervention intervention ,Long userId, HttpServletRequest request) {
        String action = "Creation";
        String details = "Intervention N°: " + intervention.getReclamation().getIdFonctionnel() + " crée";
        
        // Récupérer l'adresse IP réelle du client
        String ip_address = request.getHeader("X-Forwarded-For");
        if (ip_address == null || ip_address.isEmpty()) {
        	ip_address = request.getRemoteAddr();
        }        
        user.setId(userId);
        userHistService.save(user, action, details, ip_address);
    }

    public static void updateIntervention(UserHistService userHistService, Intervention oldIntervention, Intervention newIntervention, Long userId, HttpServletRequest request) {
        String action = "Modification";
        
        // Récupérer l'adresse IP réelle du client
        String ip_address = request.getHeader("X-Forwarded-For");
        if (ip_address == null || ip_address.isEmpty()) {
        	ip_address = request.getRemoteAddr();
        }         
        
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
        if (!Objects.equals(oldIntervention.getTechnicien().getId(), newIntervention.getTechnicien().getId()))
        {
        	details += "Technicien modifié de "+ oldIntervention.getTechnicien().getUsername() + " à " + newIntervention.getTechnicien().getUsername() + " . " ;
        }
        
        user.setId(userId);
        userHistService.save(user, action, details, ip_address);
    }

    
    public static void deleteIntervention(UserHistService userHistService, Intervention Intervention , Long userId, HttpServletRequest request) {
        String action = "Supression";
        String details = "Intervention N°: " + Intervention.getReclamation().getIdFonctionnel() + " suprimée. ";
        
        // Récupérer l'adresse IP réelle du client
        String ip_address = request.getHeader("X-Forwarded-For");
        if (ip_address == null || ip_address.isEmpty()) {
        	ip_address = request.getRemoteAddr();
        }  
        
        user.setId(userId);
        userHistService.save(user, action, details, ip_address);
    }

}

