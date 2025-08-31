package ma.radeef.interventions.endpoints.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ServiceDto {
	   private long id;
	   private String nom;
	   private DepartementDto departement;
	   private UserDto chefService;
}
