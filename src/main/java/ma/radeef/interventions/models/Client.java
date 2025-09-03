package ma.radeef.interventions.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor 
@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nomClient;
	
	@Column
	private String codeAbonnement;
	
	@Column
	private String pays;
	
	@Column
	private String codePostal;
	
	@Column
	private String ville;
	
	@Column
	private String quartier;
	
	@Column
	private String nomRue;
	
	

}
