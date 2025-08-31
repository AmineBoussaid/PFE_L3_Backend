package ma.radeef.interventions.endpoints.dtos.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

import ma.radeef.interventions.endpoints.dtos.InterventionDto;
import ma.radeef.interventions.models.Intervention;

@Mapper(componentModel = ComponentModel.SPRING, 
		uses = {EquipeDtoMapper.class, TechnicienDtoMapper.class, 
		ReclamationDtoMapper.class,DepartementDtoMapper.class,ServiceDtoMapper.class, UserDtoMapper.class })

public interface InterventionDtoMapper {
	
	InterventionDto toDto(Intervention intervention);
	
	Intervention toBean(InterventionDto interventionDto);
	
}
