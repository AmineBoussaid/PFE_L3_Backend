package ma.radeef.interventions.endpoints.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipeDto {

	private long id;
	private String nom;
	private TechnicienDto chefEquipe;
	private String createdAt;
	private String disabledAt;
	private boolean active;
	private List<TechnicienDto> techniciens;

}
