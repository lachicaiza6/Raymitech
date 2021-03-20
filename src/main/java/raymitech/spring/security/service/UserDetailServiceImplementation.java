package raymitech.spring.security.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import raymitech.spring.entities.User;
import raymitech.spring.security.entities.UserMain;
import raymitech.spring.security.serviceImp.IUserService;

@Service
public class UserDetailServiceImplementation implements UserDetailsService{

	@Autowired
	IUserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userService.getByUserName(username).get();
		
		return UserMain.build(user) ;
	}

}
