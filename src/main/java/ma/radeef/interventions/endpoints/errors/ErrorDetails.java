package ma.radeef.interventions.endpoints.errors;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDetails {
	private String timestamp;
	private String message;
	private int code;

}
