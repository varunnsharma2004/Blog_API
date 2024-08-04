package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entitys.user;
import Entitys.userData;
import Repositry.Repos;
import Repositry.UserDataRepo;
import exception.ResourceNotFoundException;
@Service
public class Data implements DataServices {

	@Autowired
	private UserDataRepo data;
	
	@Autowired
	private Repos repo;
	
	@Override
	public userData CreateUser(userData user,int authorId) {
		userData us=new  userData();
		us.setAddress(user.getAddress());
		us.setEmail(user.getEmail());
		us.setFirst_name(user.getFirst_name());
		us.setLast_name(user.getLast_name());
		us.setNumber(user.getNumber());
		us.setSemester(user.getSemester());
		
		Entitys.user authour=this.repo.findById(authorId).orElseThrow(()->new ResourceNotFoundException("User ","User Id", authorId));;
us.setAuthor(authour);
	data.save(us);
		
		return us;
	}



	@Override
	public userData UpdateUser(userData user, int id) {
		userData us=this.data.findById(id).orElseThrow(()->new ResourceNotFoundException("User ","User Id", id));
	us.setId(id);
		us.setAddress(user.getAddress());
		us.setEmail(user.getEmail());
		us.setFirst_name(user.getFirst_name());
		us.setLast_name(user.getLast_name());
		us.setNumber(user.getNumber());
		us.setSemester(user.getSemester());
	data.save(us);
		
		return us;
	}

	@Override
	public void deleteUser(int id) {
		
		userData us=this.data.findById(id).orElseThrow(()->new ResourceNotFoundException("User ","User Id", id));
		this.data.delete(us);		
	}

	

	@Override
	public userData searchUser(String user) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<userData> getUserData(int authId) {
		user us= this.repo.findById(authId).orElseThrow(()->new ResourceNotFoundException("User ","User Id", authId));
		
		List<userData> user=this.data.findByAuthor(us);
		return user;
	}




}
