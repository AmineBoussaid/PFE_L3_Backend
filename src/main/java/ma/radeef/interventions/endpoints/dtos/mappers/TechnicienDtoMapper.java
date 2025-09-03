package ma.radeef.interventions.endpoints.dtos.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

import ma.radeef.interventions.endpoints.dtos.TechnicienDto;
import ma.radeef.interventions.models.Technicien;

@Mapper(componentModel = ComponentModel.SPRING, uses = ServiceDtoMapper.class)
public interface TechnicienDtoMapper {

	
	TechnicienDto toDto(Technicien technicien);
	
	Technicien toBean(TechnicienDto technicienDto);

	
}
