package ma.radeef.interventions.endpoints.errors;

import org.springframework.http.HttpStatus;

import lombok.Getter;

public class HttpException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	@Getter
	private HttpStatus httpStatus;
	
	public HttpException(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	public HttpException(HttpStatus httpStatus, String message) {
		super(message);
		this.httpStatus = httpStatus;
		
	}

}
