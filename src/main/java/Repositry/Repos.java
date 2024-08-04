package Repositry;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Entitys.user;

public interface Repos extends JpaRepository<user, Integer> {
	List<user> findBymobileNumberAndPassword(long number,String password);
	List<user> password(String password);
	public user findBymobileNumber(long number);
	
	
}
