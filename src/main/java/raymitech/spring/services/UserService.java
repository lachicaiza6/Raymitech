package raymitech.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import raymitech.spring.entities.User;
import raymitech.spring.repository.IUserRepository;
import raymitech.spring.services.interfaces.IUserService;
@Service
public class UserService implements IUserService{

	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public void save(User user) {
		userRepository.save(user);
		
	}

	@Override
	public User findById(Long id) {
		
		return userRepository.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public List<User> findAll() {
		
		return (List<User>)userRepository.findAll();
	}

}
