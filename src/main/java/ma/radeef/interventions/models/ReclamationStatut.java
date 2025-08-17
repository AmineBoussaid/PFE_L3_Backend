package ma.radeef.interventions.models;

import lombok.Getter;

public enum ReclamationStatut {

	EN_ATTENTE("En attente"),
	EN_COURS("En cours"),
	ANNULEE("Annulée"),
	TERMINEE("Terminée");
	
	private ReclamationStatut(String description) {
		this.description = description;
	}
	
	@Getter
	private String description;
	
	public static ReclamationStatut fromDescription(String description) {
		return switch(description) {
		case "En attente" -> EN_ATTENTE;
		case "En cours" -> EN_COURS;
		case "Annulée" -> ANNULEE;
		case "Terminée" -> TERMINEE;
		default -> throw new IllegalArgumentException();
		};
	}
	
}
