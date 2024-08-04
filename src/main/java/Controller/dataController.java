package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import API_RESPONCE.ApiResponce;
import Entitys.userData;
import services.Data;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class dataController {
@Autowired
private Data auth;
	
	@PostMapping("/userData/{userId}")
	public ResponseEntity<userData> createData(@RequestBody userData data,@PathVariable("userId") int userId)
	{
	userData user=this.auth.CreateUser(data, userId);	
		return new ResponseEntity<userData>(user,HttpStatus.OK);
	}
	@GetMapping("/users/{authorId}")
	public ResponseEntity<List<userData>>getUsers(@PathVariable ("authorId") int authorId)
	{
		
		return new ResponseEntity<List<userData>>(this.auth.getUserData(authorId),HttpStatus.OK);

	}
	@DeleteMapping("/users/{authorId}")
	public ResponseEntity<ApiResponce> DeleteUser(@PathVariable("authorId") int authorId)
	{
this.auth.deleteUser(authorId);
return new ResponseEntity<ApiResponce>(new ApiResponce("UserDeleted", true),HttpStatus.OK);

	}
}
