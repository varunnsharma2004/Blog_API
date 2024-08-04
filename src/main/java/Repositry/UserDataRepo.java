package Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import Entitys.user;
import Entitys.userData;
import java.util.List;


public interface UserDataRepo extends JpaRepository<userData, Integer> {
 List<userData> findByAuthor(user author);
}
