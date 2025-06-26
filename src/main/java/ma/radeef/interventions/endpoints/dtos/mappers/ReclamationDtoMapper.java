package ma.radeef.interventions.endpoints.dtos.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

import ma.radeef.interventions.endpoints.dtos.ReclamationDto;
import ma.radeef.interventions.models.Reclamation;

@Mapper(componentModel = ComponentModel.SPRING)
public interface ReclamationDtoMapper {
	ReclamationDto toDto(Reclamation reclamation);
}
