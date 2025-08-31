package ma.radeef.interventions.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;

@Entity
public class ChefDepartement extends User {
	
	@OneToOne(fetch = FetchType.LAZY)
	private Departement departement;
}
