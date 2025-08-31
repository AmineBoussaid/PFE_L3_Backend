package ma.radeef.interventions.endpoints.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserHistoriqueDto {
	
	private Long id;
	private UserDto user;
	private String action;
    private String createdAt;
	private String details;


}
