package exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResourceNotFoundException extends RuntimeException {
public  String field;
public String fieldName;
public long id;
public ResourceNotFoundException(String field,String fieldName,long id)
{
super(String.format("%s is not Found %s:%s", field,fieldName,id));
this.field=field;
this.fieldName=fieldName;
this.id=id;
		
}
	
}
