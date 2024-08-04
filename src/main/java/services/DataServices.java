package services;

import java.util.List;

import Entitys.userData;

public interface DataServices {

	public userData CreateUser(userData user,int id);

	
	public userData UpdateUser(userData user,int id);
	
	public void deleteUser(int id);
	
	public List<userData> getUserData(int authId);
	
	public userData searchUser(String user);
	
	
}
