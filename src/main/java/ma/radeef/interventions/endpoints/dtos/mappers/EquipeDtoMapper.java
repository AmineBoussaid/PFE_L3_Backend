package ma.radeef.interventions.endpoints.dtos.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

import ma.radeef.interventions.endpoints.dtos.EquipeDto;
import ma.radeef.interventions.models.Equipe;

@Mapper(componentModel = ComponentModel.SPRING, uses = TechnicienDtoMapper.class)
public interface EquipeDtoMapper {

	EquipeDto toDto(Equipe equipe);
	
	Equipe toBean(EquipeDto equipeDto);
	
}
