package raymitech.spring.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import raymitech.spring.security.entities.Rol;
import raymitech.spring.security.enums.RolName;

@Repository
public interface IRolRepository extends JpaRepository<Rol,Long> {

	Optional<Rol> findByRolName(RolName rolName);
	
	
}
