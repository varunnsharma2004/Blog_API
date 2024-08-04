 package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entitys.user;
import Repositry.Repos;
import exception.ResourceNotFoundException;
@Service
public class Services implements UserSeriveces {
@Autowired
private Repos repo;

	@Override
	public user createUser(user us) {
		user u=new user();
		u.setEmail(us.getEmail());
		u.setInstituteName(us.getInstituteName());
		u.setMobileNumber(us.getMobileNumber());
		u.setPassword(us.getPassword());
		this.repo.save(u);
		
		return u;
	}

	@Override
	public List<user> getALLUser() {
		List<user> user=this.repo.findAll();
		return user;
	}

	@Override
	public user UpdateUser(user us, int id) {
		user u=this.repo.findById(id).orElseThrow(()->new ResourceNotFoundException("user","id",id));
		u.setEmail(us.getEmail());
		u.setInstituteName(us.getInstituteName());
		u.setMobileNumber(us.getMobileNumber());
		u.setPassword(us.getPassword());
		this.repo.save(u);
		return u;
	}

	@Override
	public void DeleteUser(int id) {
		user us=this.repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("user","id",id));
	this.repo.delete(us);	
	}

	@Override
	public List<user> getUserByNumberAndPassword(long data, String password) {
		 List<user>   us=this.repo.findBymobileNumberAndPassword(data, password);
		return us;
	}

	@Override
	public user PasswordReset(user us, long mobile) {
		user u=this.repo.findBymobileNumber(mobile);
		u.setPassword(us.getPassword());
		this.repo.save(u);
	return u;	
	}

	

	
	
	
}