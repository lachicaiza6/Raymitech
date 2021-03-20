package raymitech.spring.security.serviceImp;

import java.util.Optional;

import raymitech.spring.security.entities.Rol;
import raymitech.spring.security.enums.RolName;

public interface IRolService {
	
	public Optional<Rol> getByRolName(RolName rolName);

	public void save(Rol rol);
	
}
