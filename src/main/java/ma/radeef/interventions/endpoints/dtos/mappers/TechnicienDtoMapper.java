package ma.radeef.interventions.endpoints.dtos.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

import ma.radeef.interventions.endpoints.dtos.TechnicienDto;
import ma.radeef.interventions.models.Technicien;

@Mapper(componentModel = ComponentModel.SPRING, uses = ServiceDtoMapper.class)
public interface TechnicienDtoMapper {

    @Mapping(source = "image", target = "imageBase64")
	TechnicienDto toDto(Technicien technicien);
	
	Technicien toBean(TechnicienDto technicienDto);

	
}
