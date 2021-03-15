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
import raymitech.spring.entities.Comments;
import raymitech.spring.services.interfaces.ICommentsService;

@RestController
@RequestMapping("/api/comment")
public class CommentsController {

	@Autowired
	private ICommentsService service;
	
	@GetMapping("")
	public List<Comments> findAll(){
		List<Comments> comments=service.findAll();
		if(comments.size()==0) {
			throw new NotFoundException("No hay comentarios");
		}
		return comments;		
	}
	
	@PostMapping()
	public ResponseEntity<?> save(@RequestBody Comments comments){
		
		service.save(comments);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public Comments update(@RequestBody Comments comments,@PathVariable Long id ) {
		service.save(comments);
		return comments;
	}
}
