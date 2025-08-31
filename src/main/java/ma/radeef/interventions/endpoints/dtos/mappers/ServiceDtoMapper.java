package ma.radeef.interventions.endpoints.dtos.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

import ma.radeef.interventions.endpoints.dtos.ServiceDto;
import ma.radeef.interventions.models.Service;

@Mapper(componentModel = ComponentModel.SPRING , uses = {UserDtoMapper.class, DepartementDtoMapper.class})
public interface ServiceDtoMapper {
	
	@Mapping(target = "chefService", source = "chefService")
	@Mapping(target = "departement", source = "departement")
	ServiceDto toDto(Service service);
	
	
}
