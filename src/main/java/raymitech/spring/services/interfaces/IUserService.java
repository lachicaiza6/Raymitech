package raymitech.spring.services.interfaces;

import java.util.List;

import raymitech.spring.entities.User;

public interface IUserService {
	
	public void save(User user);
	public User findById(Long id);
	public void delete(Long id);
	public List<User> findAll();
	
}
