package ma.radeef.interventions.models;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Intervention {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String titre;
	
	@Column
	private String status;
	
	@Column
	private LocalDateTime dateDebut;
	
	@Column
	private LocalDateTime dateFin;
	
	@Column(nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String createdAt;
	
	@Column
	private String description;
		
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "createur_id")
    private User createur;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reclamation_id")
    private Reclamation reclamation;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departement_id")
    private Departement departement;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    private Service service;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "technicien_id")
    private Technicien technicien;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;
	
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rapport_id")
    private Rapport rapport;
	


}
