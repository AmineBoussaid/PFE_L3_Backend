package ma.radeef.interventions.endpoints.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.radeef.interventions.models.Intervention;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InterventionDTO {
	
	private Intervention intervention;
	private List<TechnicienDto> techniciens;
	

}
