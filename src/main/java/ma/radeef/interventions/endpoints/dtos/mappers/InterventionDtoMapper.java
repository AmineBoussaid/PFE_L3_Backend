package ma.radeef.interventions.endpoints.dtos.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

import ma.radeef.interventions.models.Intervention;
import ma.radeef.interventions.models.InterventionHist;


@Mapper(componentModel = ComponentModel.SPRING)
public interface InterventionDtoMapper {
	
	InterventionHist toDto(Intervention intervention);

}
