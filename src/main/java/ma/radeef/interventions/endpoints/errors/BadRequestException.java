package ma.radeef.interventions.endpoints.errors;

import org.springframework.http.HttpStatus;

public class BadRequestException extends HttpException {
	
	public BadRequestException(String message) {
		super(HttpStatus.BAD_REQUEST, message);
	}
	
	public BadRequestException() {
		super(HttpStatus.BAD_REQUEST);
	}

}
