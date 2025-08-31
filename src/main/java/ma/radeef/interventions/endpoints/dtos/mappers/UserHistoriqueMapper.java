package ma.radeef.interventions.endpoints.dtos.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

import ma.radeef.interventions.endpoints.dtos.UserHistoriqueDto;
import ma.radeef.interventions.models.UserHistorique;

@Mapper(componentModel = ComponentModel.SPRING , uses = UserDtoMapper.class)
public interface UserHistoriqueMapper {
	
	UserHistoriqueDto toDto(UserHistorique userHistorique);
	

}
