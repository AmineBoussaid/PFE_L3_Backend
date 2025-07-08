package ma.radeef.interventions.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "intervention_historique")
public class InterventionHist{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "intervention_id")
    private Intervention intervention;
	
	@Column
	private String titre;
		
	@Column
	private String status;
	
	@Column(nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String created_at;
	
	@Column
	private String description;
		
	@ManyToOne
    @JoinColumn(name = "createur_id")
    private User createur;
	
	@ManyToOne
    @JoinColumn(name = "reclamation_id")
    private Reclamation reclamation;
		
	@ManyToOne
	@JoinColumn(name = "departement_id")
	private Departement departement;
	
	@ManyToOne
    @JoinColumn(name = "change_par")
    private User user;

}
