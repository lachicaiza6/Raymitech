package raymitech.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import raymitech.spring.entities.User;

public interface IUserRepository extends JpaRepository<User,Long>  {

}
