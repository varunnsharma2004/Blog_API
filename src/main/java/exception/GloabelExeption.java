package exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import API_RESPONCE.ApiResponce;

@RestControllerAdvice
public class GloabelExeption {

	@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<ApiResponce> ResourceNotFound(ResourceNotFoundException ex)
	{
		String msg=ex.getMessage();
		
	return new ResponseEntity<ApiResponce>(new ApiResponce(msg, false),HttpStatus.BAD_REQUEST);
	}
@ExceptionHandler(MethodArgumentNotValidException.class)
	
	public ResponseEntity<Map<String,String>> MethodArg(MethodArgumentNotValidException ex)
	{
		Map<String,String> arg=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((er)->{
			String FieldName=((FieldError) er).getField();
			String msg=er.getDefaultMessage();
			arg.put(FieldName, msg);
		});
		return new  ResponseEntity<Map<String,String>>(arg,HttpStatus.BAD_REQUEST);
	}
@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
public ResponseEntity<ApiResponce> MehtodNodFound(HttpRequestMethodNotSupportedException ex)
{
	String msg=ex.getMessage();
	
return new ResponseEntity<ApiResponce>(new ApiResponce(msg, false),HttpStatus.BAD_REQUEST);
}
}
