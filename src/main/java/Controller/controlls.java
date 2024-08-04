package Controller;

import java.io.Console;
import java.util.List;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import API_RESPONCE.ApiResponce;
import Entitys.user;
import services.Services;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class controlls {
@Autowired
private Services ser;
@PostMapping("/create")
public ResponseEntity<user> createUser(@Validated  @RequestBody user us)
{
	
	return new ResponseEntity<user>(this.ser.createUser(us),HttpStatus.OK);

}
@PutMapping("/Update/{id}")
public ResponseEntity<user> UpdateUser(@RequestBody user us, @PathVariable("id") int id)
{
	user u=this.ser.UpdateUser(us, id);
	return new ResponseEntity<>(u,HttpStatus.OK);
}
@GetMapping("/getUser")
public ResponseEntity<List<user>> getUser()
{
	List<user> list = this.ser.getALLUser();
	return new ResponseEntity<>(list,HttpStatus.OK);
}
@DeleteMapping("/delete/{id}")

public ResponseEntity<ApiResponce> delete(@PathVariable("id") int id){
	this.ser.DeleteUser(id);
	return new ResponseEntity<ApiResponce>(new ApiResponce("User Deleted",true),HttpStatus.OK);
}

@GetMapping("/getByNumber/{number}/password/{password}")
public ResponseEntity<List<user>> loginAPI(@PathVariable("number") long number,@PathVariable("password") String password){
	List<user> list=this.ser.getUserByNumberAndPassword(number, password);
	if(list.isEmpty()) {

return new ResponseEntity<List<user>>(HttpStatus.BAD_REQUEST);
	}
return new ResponseEntity<List<user>>(list,HttpStatus.OK);
}
@PostMapping("/user/{number}")
public ResponseEntity<user> resetPassword(@RequestBody user us,@PathVariable("number") long number){
;
	return new ResponseEntity<>(	this.ser.PasswordReset(us, number),HttpStatus.OK);
}

}