package Entitys;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(uniqueConstraints = { 
	@UniqueConstraint(columnNames = {"mobileNumber"}),
	// @UniqueConstraint(columnNames = {"email"})
})
public class user {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String instituteName;
	
	private long mobileNumber;

	private String email;

	private String password;

	
	

}
