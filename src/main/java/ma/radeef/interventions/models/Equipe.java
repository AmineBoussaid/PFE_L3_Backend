package ma.radeef.interventions.models;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
	private Technicien chefEquipe;
	
    @Column(nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String createdAt;
    
    @Column
    private String disabledAt;
    
    @Column
    private boolean active;
    
    @OneToOne(fetch = FetchType.LAZY)
    private Intervention intervention;
    
    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "technicien_equipe",
			joinColumns = @JoinColumn(name = "equipe_id"),
			inverseJoinColumns = @JoinColumn(name = "technicien_id")
		)
    private List<Technicien> techniciens;

}
