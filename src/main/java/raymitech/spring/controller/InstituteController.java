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
import raymitech.spring.entities.Institute;
import raymitech.spring.services.interfaces.IInstituteService;

@RestController
@RequestMapping("/api/institute")
public class InstituteController {
	
	@Autowired
	private IInstituteService service;
	
	@GetMapping("")
	public List<Institute> findAll(){
		List<Institute> institute=service.findAll();
		if(institute.size()==0) {
			throw new NotFoundException("no hay instituciones registradas");			
		}
		return institute;
	}
	
	@PostMapping("/")
	public ResponseEntity<?> save(@RequestBody Institute institute){
		service.save(institute);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("id/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public Institute update(@RequestBody Institute institute, @PathVariable long id) {
		service.save(institute);
		return institute;
	}
	
	
	
}
