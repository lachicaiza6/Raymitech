package raymitech.spring.services.interfaces;

import java.util.List;

import raymitech.spring.entities.Category;


public interface ICategoryService {
	
	public void save(Category category);
	public Category findById(Long id);
	public void delete(Long id);
	public List<Category> findAll();
	
	
	
}
