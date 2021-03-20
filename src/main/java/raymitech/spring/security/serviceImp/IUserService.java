package raymitech.spring.security.serviceImp;

import java.util.List;
import java.util.Optional;

import raymitech.spring.entities.User;

public interface IUserService {
	
	public void save(User user);
	public User findById(Long id);
	public void delete(Long id);
	public List<User> findAll();
	public Optional<User> getByUserName(String userName);
	
	public boolean existsByUserName(String userName);
	
	public boolean existsByEmail(String email);
	
	
	
}
