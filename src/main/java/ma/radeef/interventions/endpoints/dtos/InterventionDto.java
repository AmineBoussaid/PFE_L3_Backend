package ma.radeef.interventions.endpoints.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class InterventionDto {

	private long id;
	private String titre;
	private String status;
	private LocalDateTime dateDebut;
	private LocalDateTime dateFin;
    private String createdAt;
	private String description;
    private UserDto createur;
    private ReclamationDto reclamation;
    private DepartementDto departement;
    private ServiceDto service;
	private TechnicienDto technicien;
	private EquipeDto equipe;

}
