package raymitech.spring.services.interfaces;

import java.util.List;

import raymitech.spring.entities.Comments;

public interface ICommentsService {

		public void save(Comments comment);
		public Comments findById(Long id);
		public void delete(Long id);
		public List<Comments> findAll();
		
}
