package raymitech.spring.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import raymitech.spring.entities.Message;
import raymitech.spring.entities.User;
import raymitech.spring.security.dto.JwtDto;
import raymitech.spring.security.dto.NewUser;
import raymitech.spring.security.dto.UserLogin;
import raymitech.spring.security.entities.Rol;
import raymitech.spring.security.enums.RolName;
import raymitech.spring.security.jwt.JwtProvider;
import raymitech.spring.security.service.RolService;
import raymitech.spring.security.service.UserService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
	
	@Autowired
	PasswordEncoder passeordEncoder;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserService userService;
	
	@Autowired
	RolService rolService;
	
	@Autowired
	JwtProvider jwtProvider;
	
	@PostMapping("/nuevo")
	public ResponseEntity<?> newUsr(@Valid @RequestBody NewUser newUser,BindingResult bindingResult){
	if(bindingResult.hasErrors()) 
		return new ResponseEntity(new Message("Campos mal puestos"),HttpStatus.BAD_REQUEST);
	if(userService.existsByUserName(newUser.getUserName()))
		return new ResponseEntity(new Message("Ese nombre ya existe"),HttpStatus.BAD_REQUEST);
	if(userService.existsByEmail(newUser.getEmail()))
		return new ResponseEntity("ese email ya existe",HttpStatus.BAD_REQUEST);
	User user=new User(newUser.getName(),newUser.getUserName(),newUser.getEmail(),
			passeordEncoder.encode(newUser.getPassword()));
	Set<Rol> roles=new HashSet<>();
	roles.add(rolService.getByRolName(RolName.ROLE_USER).get());
	if(newUser.getRoles().contains("admin")) 
		roles.add(rolService.getByRolName(RolName.ROLE_ADMIN).get());
	
	user.setRoles(roles);
	userService.save(user);
	return new ResponseEntity<>(new Message("Usuario Guardado"),HttpStatus.CREATED);
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<JwtDto> login(@Valid @RequestBody UserLogin userLogin, BindingResult bindingResult){
		if(bindingResult.hasErrors()) 
			return new ResponseEntity(new Message("Campos Puestos"),HttpStatus.BAD_REQUEST);
		Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUserName(),userLogin.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt=jwtProvider.generateToken(authentication);
		UserDetails userDetails=(UserDetails) authentication.getPrincipal();
		JwtDto jwtDto= new JwtDto(jwt, userDetails.getUsername(),userDetails.getAuthorities());
		return new ResponseEntity(jwtDto,HttpStatus.OK);
	}
	
}
