package ma.radeef.interventions.endpoints.dtos.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

import ma.radeef.interventions.endpoints.dtos.RapportDto;
import ma.radeef.interventions.models.Rapport;

@Mapper(componentModel = ComponentModel.SPRING, uses =  {UserDtoMapper.class})
public interface RapportDtoMapper {
	
	RapportDto toDto(Rapport rapport);

	Rapport toBean(RapportDto rapportDto);
}
