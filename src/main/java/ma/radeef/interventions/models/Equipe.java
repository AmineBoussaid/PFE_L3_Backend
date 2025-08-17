package ma.radeef.interventions.models;


import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Equipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nom;

	@ManyToOne
	private User chefEquipe;
	
    @Column(nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String createdAt;
    
    @Column
    private String disabledAt;
    
    @Column
    private boolean active;
    
    @OneToOne(fetch = FetchType.LAZY )
	@JsonIgnore
    @JoinColumn(name = "intervention_id")
    private Intervention intervention;
    
    @OneToMany(mappedBy = "equipe")
    private Set<TechnicienEquipe> technicienEquipes;

}
