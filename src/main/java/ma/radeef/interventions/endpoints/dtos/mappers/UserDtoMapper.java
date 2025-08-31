package ma.radeef.interventions.endpoints.dtos.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

import ma.radeef.interventions.endpoints.dtos.UserDto;
import ma.radeef.interventions.models.Agent;
import ma.radeef.interventions.models.ChefDepartement;
import ma.radeef.interventions.models.ChefService;
import ma.radeef.interventions.models.User;

@Mapper(componentModel = ComponentModel.SPRING)
public interface UserDtoMapper {

	UserDto toDto(User user);

}
