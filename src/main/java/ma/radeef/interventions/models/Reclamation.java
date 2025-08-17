package ma.radeef.interventions.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Entity
public class Reclamation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String idFonctionnel;
	
	@Column
	private String nomClient;
	
	@Column
	private String codeAbonnement;
	
	@Column
	private String pays;
	
	@Column
	private String ville;
	
	@Column
	private String quartier;
	
	@Column
	private String nomRue;
	
	@Column
	private String category;
	
	@Column
	private String situation;
	
	@Column
	private String periode;
	
	@Column
	private String occurrence;
	
	@Column
	private String telephone;
	
	@Column
	private String email;
	
	@Column
	//@Enumerated(EnumType.STRING)
	private String status ;
	
	@Column
	private String description;
	
    @Column(nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String created_at;
	
    @ManyToOne
    @JoinColumn(name = "agent_id")
    private User agent;
    
    @ManyToOne
    @JoinColumn(name = "service_id")
    private ServiceD service;
	
    


}
