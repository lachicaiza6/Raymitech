package raymitech.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import raymitech.spring.entities.Category;
import raymitech.spring.repository.ICategoryRepository;
import raymitech.spring.services.interfaces.ICategoryService;

@Service
public class CategoryService implements ICategoryService{

	@Autowired
	private ICategoryRepository categoryService;
	
	@Override
	public void save(Category category) {
		categoryService.save(category);
		
	}

	@Override
	public Category findById(Long id) {
		
		return categoryService.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		categoryService.deleteById(id);
		
	}

	@Override
	public List<Category> findAll() {
		return (List<Category>) categoryService.findAll();
	}

	
}
