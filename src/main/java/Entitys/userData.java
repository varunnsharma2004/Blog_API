package Entitys;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Data
@Table(uniqueConstraints = { 
	@UniqueConstraint(columnNames = {"number"}),
	@UniqueConstraint(columnNames = {"email"})})
public class userData {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	private String first_name;
	
	private String last_name;
	
	private String semester;
	
	
	private long number;
	
	private String address;
	
	private String email;
	@ManyToOne
	private user author;
}
