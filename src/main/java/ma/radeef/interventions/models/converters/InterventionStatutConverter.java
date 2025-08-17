package ma.radeef.interventions.models.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import ma.radeef.interventions.models.InterventionStatut;

@Converter(autoApply = true)
public class InterventionStatutConverter implements AttributeConverter<InterventionStatut, String>  {

	@Override
	public String convertToDatabaseColumn(InterventionStatut attribute) {
		return attribute.getDescription();
	}

	@Override
	public InterventionStatut convertToEntityAttribute(String dbData) {
		return InterventionStatut.fromDescription(dbData);
	}

}
