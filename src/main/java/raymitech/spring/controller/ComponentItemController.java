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
import raymitech.spring.entities.ComponentItem;
import raymitech.spring.services.interfaces.IComponentItemService;

@RestController
@RequestMapping("/api/componentitem")
public class ComponentItemController {

	@Autowired
	private IComponentItemService service;
	
	@GetMapping("")
	public List<ComponentItem> findAll(){
		List<ComponentItem> componentItem=service.findAll();
		if(componentItem.size()==0) {
			throw new NotFoundException("No existen componentes");
			
		}
		return componentItem;
	}
	
	@PostMapping("/")
	public ResponseEntity<?> save(@RequestBody ComponentItem componentItem){
		service.save(componentItem);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public ComponentItem update(@RequestBody ComponentItem componentItem, @PathVariable Long id) {
		service.save(componentItem);
		return componentItem;
	}
	
	
	
	
}
