package ma.radeef.interventions.endpoints.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TechnicienDto {

    private long id;
    private String username;
    private String email;
    private String description;
    private ServiceDto service;
    
}
