package ma.radeef.interventions.endpoints.dtos.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

import ma.radeef.interventions.endpoints.dtos.InterventionHistoriqueDto;
import ma.radeef.interventions.models.Intervention;
import ma.radeef.interventions.models.InterventionHistorique;


@Mapper(componentModel = ComponentModel.SPRING ,
		uses = {InterventionDtoMapper.class,EquipeDtoMapper.class, TechnicienDtoMapper.class, 
				ReclamationDtoMapper.class,DepartementDtoMapper.class,ServiceDtoMapper.class, UserDtoMapper.class})

public interface InterventionHistoriqueMapper {
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "intervention", source = ".")
	InterventionHistorique toHistorique(Intervention intervention);
	
	InterventionHistoriqueDto toDto(InterventionHistorique interventionHistorique);


}
