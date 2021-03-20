package raymitech.spring.security.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import raymitech.spring.entities.User;
import raymitech.spring.security.repository.IUserRepository;
import raymitech.spring.security.serviceImp.IUserService;
@Service
@Transactional
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

	@Override
	public Optional<User> getByUserName(String userName) {
		
		return userRepository.findByUserName(userName);
	}


	@Override
	public boolean existsByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.existsByEmail(email);
	}

	@Override
	public boolean existsByUserName(String userName) {
		// TODO Auto-generated method stub
		return userRepository.existsByUserName(userName);
	}

}
