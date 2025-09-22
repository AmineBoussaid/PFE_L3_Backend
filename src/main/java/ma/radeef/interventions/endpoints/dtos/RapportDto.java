package ma.radeef.interventions.endpoints.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.radeef.interventions.models.User;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RapportDto {
	
	private Long id;
	private UserDto createur;
    private String createdAt;
    private Long interventionId;
	private String description;

}
