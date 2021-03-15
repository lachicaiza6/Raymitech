package raymitech.spring.services.interfaces;

import java.util.List;

import raymitech.spring.entities.Post;

public interface IPostService {

	public void save(Post post);
	public Post findById(Long id);
	public void delete(Long id);
	public List<Post> findAll();
	
	
}
