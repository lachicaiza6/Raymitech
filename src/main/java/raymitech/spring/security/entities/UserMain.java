package raymitech.spring.security.entities;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import raymitech.spring.entities.User;

public class UserMain implements UserDetails {
	
	private String name;
	
	private String userName;
	
	private String email;
	
	private String password;
	
	private Collection<? extends GrantedAuthority> authorities;

		
	public UserMain(String name, String userName, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserMain build(User user) {
		List<GrantedAuthority> autorities=
				user.getRoles().stream().map(rol-> new SimpleGrantedAuthority(rol.getRolNombre()
						.name())).collect(Collectors.toList());
	return new UserMain(user.getName(),user.getUserName(),user.getEmail(),user.getPassword(),autorities);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getName() {
		return name;
	}



	public String getEmail() {
		return email;
	}

	
	
	
	
	
}
