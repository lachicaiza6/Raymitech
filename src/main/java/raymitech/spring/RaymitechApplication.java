package raymitech.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"raymitech.spring.services,..." })
public class RaymitechApplication {

	public static void main(String[] args) {
		SpringApplication.run(RaymitechApplication.class, args);
	}

}
