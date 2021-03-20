package raymitech.spring.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import raymitech.spring.security.entities.Rol;
import raymitech.spring.security.enums.RolName;
import raymitech.spring.security.service.RolService;
@Component
public class CreateRoles implements CommandLineRunner {

	@Autowired
	RolService rolService;
	
	@Override
	public void run(String... args) throws Exception {
		Rol rolAdmin=new Rol(RolName.ROLE_ADMIN);
		Rol rolUser=new Rol(RolName.ROLE_USER);
		rolService.save(rolAdmin);
		rolService.save(rolUser);
		
	}
	
}
