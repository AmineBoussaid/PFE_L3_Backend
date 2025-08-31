package ma.radeef.interventions.endpoints.dtos.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

import ma.radeef.interventions.endpoints.dtos.DepartementDto;
import ma.radeef.interventions.models.Departement;

@Mapper(componentModel = ComponentModel.SPRING, uses = TechnicienDtoMapper.class)
public interface DepartementDtoMapper {

	DepartementDto toDto(Departement departement);
	
}
