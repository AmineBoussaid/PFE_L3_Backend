package ma.radeef.interventions.endpoints.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReclamationStatusCount {
	
	private String status;
	private Long count;

}
