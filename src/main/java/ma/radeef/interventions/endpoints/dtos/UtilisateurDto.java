package ma.radeef.interventions.endpoints.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UtilisateurDto {
	private int id;
	private String nom;
	private String prenom;
	private String login;
	private String password;
}
