package services;

import java.util.List;

import Entitys.user;

public interface UserSeriveces {

 public user createUser(user us);
 
 public List<user> getALLUser();
 
 public user UpdateUser(user us,int id);
 
 public void DeleteUser(int id);
 
 public List<user> getUserByNumberAndPassword(long data,String password);
 
 public user PasswordReset(user us,long mobile);
 
 
}
