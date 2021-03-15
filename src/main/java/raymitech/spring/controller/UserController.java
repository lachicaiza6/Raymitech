package raymitech.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import raymitech.spring.Exceptions.NotFoundException;
import raymitech.spring.entities.User;
import raymitech.spring.services.interfaces.IUserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired 
	private IUserService service;
	
	@GetMapping("")
	public List<User> save(){
		List<User> user=service.findAll();
		if(user.size()==0) {
			throw new NotFoundException("No existen Usuarios");
		}
		return user;		
	}
	
	@PostMapping("/")
	public ResponseEntity<?> save(@RequestBody User user){
		service.save(user);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public User update(@RequestBody User user, @PathVariable Long id) {
		service.save(user);
		return user;
	}
	
	
	
}
