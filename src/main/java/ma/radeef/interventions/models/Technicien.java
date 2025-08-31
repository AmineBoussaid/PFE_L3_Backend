package ma.radeef.interventions.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Technicien extends User {
	
	
	@OneToOne
    private Service service;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "technicien_equipe",
		joinColumns = @JoinColumn(name = "technicien_id"),
		inverseJoinColumns = @JoinColumn(name = "equipe_id")
	)
    private List<Equipe> equipe;

}
