package raymitech.spring.services.interfaces;

import java.util.List;

import raymitech.spring.entities.CategoryComponent;

public interface ICategoryComponentService {
	
	public void save(CategoryComponent categoryComponent);
	public CategoryComponent findById(Long id);
	public void delete(Long id);
	public List<CategoryComponent> findAll();

}
