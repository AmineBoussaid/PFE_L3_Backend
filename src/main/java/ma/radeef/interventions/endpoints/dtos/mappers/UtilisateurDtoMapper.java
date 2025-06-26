package ma.radeef.interventions.endpoints.dtos.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

import ma.radeef.interventions.endpoints.dtos.UtilisateurDto;
import ma.radeef.interventions.models.Utilisateur;

@Mapper(componentModel = ComponentModel.SPRING)
public interface UtilisateurDtoMapper {
	
	public UtilisateurDto toDto(Utilisateur utilisateur);
	
}
