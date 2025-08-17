package ma.radeef.interventions.services.utils;

import ma.radeef.interventions.models.Client;
import ma.radeef.interventions.models.Reclamation;

public class CopieAdresse {
	
	public static Reclamation copie(Client client, Reclamation reclamation) {
		
		if ( client == null ) {
	        return null;
	        
	    }else {
	        reclamation.setCodeAbonnement( client.getCodeAbonnement() );
	        reclamation.setNomRue( client.getNomRue() );
	        reclamation.setPays( client.getPays() );
	        reclamation.setQuartier( client.getQuartier() );
	        reclamation.setVille( client.getVille() );
	    	return reclamation;
	    }
    }

}
