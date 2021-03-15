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
import raymitech.spring.entities.Post;
import raymitech.spring.services.interfaces.IPostService;

@RestController
@RequestMapping("/api/post")
public class PostController {

	@Autowired
	private IPostService service;
	
	@GetMapping("")
	public List<Post> findAll(){
		List<Post> post=service.findAll();
		if(post.size()==0) {
			throw new NotFoundException("No existe ningun post");
			
		}
		return post;
	}
	
	@PostMapping("/")
	public ResponseEntity<?> save(@RequestBody Post post){
		service.save(post);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.ok().build();				
	}
	
	@PutMapping("/{id}")
	public Post update(@RequestBody Post post, @PathVariable Long id){
		service.save(post);
		return post;
	}
	
	
}
