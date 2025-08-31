package ma.radeef.interventions.endpoints.errors.handler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ma.radeef.interventions.endpoints.errors.ErrorDetails;
import ma.radeef.interventions.endpoints.errors.HttpException;

@ControllerAdvice(annotations = RestController.class)
public class RestControllerAdvice {
	
	
	@ExceptionHandler(HttpException.class)
	@ResponseBody
	public ErrorDetails handleNotFoundException(HttpException ex) {
		return ErrorDetails.builder()
				.code(ex.getHttpStatus().value())
				.message(ex.getMessage())
				.timestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
				.build();
	}

	

}
