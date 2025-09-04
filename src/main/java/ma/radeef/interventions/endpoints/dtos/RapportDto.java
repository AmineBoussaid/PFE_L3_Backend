package ma.radeef.interventions.endpoints.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RapportDto {
	
	private Long id;
	private TechnicienDto technicien;
    private String createdAt;
    private Long interventionId;
	private String description;
	
}
