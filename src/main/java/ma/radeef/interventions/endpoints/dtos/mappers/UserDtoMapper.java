package ma.radeef.interventions.endpoints.dtos.mappers;


import java.util.Base64;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.Named;

import ma.radeef.interventions.endpoints.dtos.UserDto;
import ma.radeef.interventions.models.User;

@Mapper(componentModel = ComponentModel.SPRING)
public interface UserDtoMapper {

    @Mapping(source = "image", target = "imageBase64"/*, qualifiedByName = "encodeImage"*/)
	UserDto toDto(User user);

    // Méthode explicite pour convertir le tableau d'octets en Base64
    /*@Named("encodeImage")
    default String encodeImage(String image) {
        return (image != null) ? Base64.getEncoder().encodeToString(image) : null;
    }*/

}
