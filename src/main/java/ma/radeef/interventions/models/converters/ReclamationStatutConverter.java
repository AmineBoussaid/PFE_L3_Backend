package ma.radeef.interventions.models.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import ma.radeef.interventions.models.ReclamationStatut;

@Converter(autoApply = true)
public class ReclamationStatutConverter implements AttributeConverter<ReclamationStatut, String>  {

	@Override
	public String convertToDatabaseColumn(ReclamationStatut attribute) {
		return attribute.getDescription();
	}

	@Override
	public ReclamationStatut convertToEntityAttribute(String dbData) {
		return ReclamationStatut.fromDescription(dbData);
	}

}
