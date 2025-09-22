package ma.radeef.interventions.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor 
@Entity
public class Technicien extends User {
	
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    private Service service;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "technicien_equipe",
		joinColumns = @JoinColumn(name = "technicien_id"),
		inverseJoinColumns = @JoinColumn(name = "equipe_id")
	)
    private List<Equipe> equipe;

	
}
