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
import raymitech.spring.entities.CategoryComponent;
import raymitech.spring.services.interfaces.ICategoryComponentService;

@RestController
@RequestMapping("/api/CatComponent")
public class CategoryComponentController {

	@Autowired
	private ICategoryComponentService service;
	
	@GetMapping("")
	public List<CategoryComponent> findAll(){
		List<CategoryComponent> catComponent=service.findAll();
		if(catComponent.size()==0) {
			throw new NotFoundException("No existe ninguna categoria de componente");
		}
		return catComponent;	
	}
	
	@PostMapping("/")
	public ResponseEntity<?> save(@RequestBody CategoryComponent categorycomponent){
		service.save(categorycomponent);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public CategoryComponent update(@RequestBody CategoryComponent categoryComponent, @PathVariable Long id) {
		service.save(categoryComponent);
		return categoryComponent;
		
	} 
	
	
	
}
