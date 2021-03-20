package raymitech.spring.security.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import raymitech.spring.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User,Long>  {

	Optional<User> findByUserName(String userName);
	
	boolean existsByUserName(String Username);
	
	boolean existsByEmail(String email);
	
	
}
