package ma.radeef.interventions.models;

import lombok.Getter;

public enum InterventionStatut {

	EN_COURS("En cours"),
	ANNULEE("Annulée"),
	TERMINEE("Terminée");
	
	private InterventionStatut(String description) {
		this.description = description;
	}
	
	@Getter
	private String description;
	
	public static InterventionStatut fromDescription(String description) {
		return switch(description) {
		case "En cours" -> EN_COURS;
		case "Annulée" -> ANNULEE;
		case "Terminée" -> TERMINEE;
		default -> throw new IllegalArgumentException();
		};
	}
	
}
