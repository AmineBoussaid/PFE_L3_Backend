package ma.radeef.interventions.endpoints.dtos.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

import ma.radeef.interventions.models.Intervention;
import ma.radeef.interventions.models.InterventionHist;


@Mapper(componentModel = ComponentModel.SPRING)
public interface InterventionHistoriqueMapper {
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "intervention", source = ".")
	InterventionHist toHistorique(Intervention intervention);

}
