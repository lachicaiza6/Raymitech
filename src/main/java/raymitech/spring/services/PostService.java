package raymitech.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import raymitech.spring.entities.Post;
import raymitech.spring.repository.IPostRepository;
import raymitech.spring.services.interfaces.IPostService;

@Service
public class PostService implements IPostService {

	@Autowired
	private IPostRepository postRepository;
	
	@Override
	public void save(Post post) {
		postRepository.save(post);
		
	}

	@Override
	public Post findById(Long id) {

		return postRepository.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		postRepository.deleteById(id);
		
	}

	@Override
	public List<Post> findAll() {
		
		return (List<Post>)postRepository.findAll();
	}

}
