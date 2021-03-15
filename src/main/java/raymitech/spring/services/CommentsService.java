package raymitech.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import raymitech.spring.entities.Comments;
import raymitech.spring.repository.ICommentsRepository;
import raymitech.spring.services.interfaces.ICommentsService;
@Service
public class CommentsService implements ICommentsService{

	@Autowired
	private ICommentsRepository commentsRepository;
	
	@Override
	public void save(Comments comment) {
		commentsRepository.save(comment);
		
	}

	@Override
	public Comments findById(Long id) {
		
		return commentsRepository.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		commentsRepository.deleteById(id);
		
	}

	@Override
	public List<Comments> findAll() {
		
		return (List<Comments>)commentsRepository.findAll();
	}

}
