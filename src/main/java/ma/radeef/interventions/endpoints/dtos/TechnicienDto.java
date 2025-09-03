package ma.radeef.interventions.endpoints.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.radeef.interventions.models.Service;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TechnicienDto {

    private Long id;
    private String username;
    private String email;
    private String description;
    private ServiceDto service;
    
}
