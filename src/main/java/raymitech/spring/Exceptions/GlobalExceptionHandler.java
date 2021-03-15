package raymitech.spring.Exceptions;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler
{

	@ExceptionHandler(Exception.class)
	  public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
	    ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	@ExceptionHandler(NotFoundException.class)
	  public final ResponseEntity<ExceptionResponse> handleUserNotFoundException(NotFoundException ex, WebRequest request) {
	
		 ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
			        request.getDescription(false));
			    return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
		//response.sendError(HttpStatus.NOT_FOUND.value());
	}
	@ExceptionHandler(ServerException.class)
	  public final ResponseEntity<ExceptionResponse> handleUserServerException(ServerException ex, WebRequest request) {
	
		 ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
			        request.getDescription(false));
			    return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		//response.sendError(HttpStatus.NOT_FOUND.value());
	}

	@ExceptionHandler(UnSupporterFieldPatchException.class)
	public void springUnSupportedFieldPatch(HttpServletResponse response) throws IOException
	{
		response.sendError(HttpStatus.METHOD_NOT_ALLOWED.value());
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request)
	{
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", new Date());
		body.put("status", status.value());

		List<String> errors = ex.getBindingResult().getFieldErrors().stream()
				.map(x -> x.getDefaultMessage()).collect(Collectors.toList());
		body.put("errors", errors);
		return new ResponseEntity<>(body, headers, status);
	}
}
