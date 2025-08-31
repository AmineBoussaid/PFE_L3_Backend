package ma.radeef.interventions.endpoints.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ReclamationDto {
	
	private Long id;
	
	private String idFonctionnel;
	
	private String nomClient;
	
	private String codeAbonnement;
	
	private String pays;
	
	private String ville;
	
	private String quartier;
	
	private String nomRue;
	
	private String category;
	
	private String situation;
	
	private String periode;
	
	private String occurrence;
	
	private String telephone;

	private String email;

	private String status ;

	private String description;

    private String createdAt;
	
    private UserDto agent;
    
    private ServiceDto service;

}
