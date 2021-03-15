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
import raymitech.spring.Exceptions.ServerException;
import raymitech.spring.entities.Category;
import raymitech.spring.services.interfaces.ICategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private ICategoryService service;
	
	
	@GetMapping("")
	public List<Category> findAll(){
		List<Category> categories=service.findAll();
		if(categories.size()==0) {
			throw new NotFoundException("No existe Categoria");
		}
		return categories;
	}
	
	@PostMapping("/")
	public ResponseEntity<?> save(@RequestBody Category category){
		try {
			
		}catch(Exception ex) {
			throw new ServerException("Error en el servidor al guardar categoria"+category.getName(),ex);
			
		}
			service.save(category);
			return ResponseEntity.ok(category);
	}
	@DeleteMapping("/id/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.ok().build();		
	}
	
	@PutMapping("/{id}")
	public Category update(@RequestBody Category category,@PathVariable Long id){
		service.save(category);
		return category;
	}
	
	
}
