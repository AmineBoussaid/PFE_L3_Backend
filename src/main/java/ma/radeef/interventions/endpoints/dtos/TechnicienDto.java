package ma.radeef.interventions.endpoints.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TechnicienDto {

    private Long userId;
    private String username;
    private String email;
    private String role;
    private Long serviceId;
    private String serviceName;
    
}
