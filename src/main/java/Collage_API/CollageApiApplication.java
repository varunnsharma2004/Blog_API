package Collage_API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"Controller","services","exception","API_RESPONCE"})
@EnableJpaRepositories(basePackages = {"Repositry"})
@EntityScan(basePackages = {"Entitys"})
public class CollageApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollageApiApplication.class, args);
	}

}
