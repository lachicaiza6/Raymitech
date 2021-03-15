package raymitech.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import raymitech.spring.entities.CategoryComponent;
import raymitech.spring.repository.ICategoryComponentRepository;
import raymitech.spring.services.interfaces.ICategoryComponentService;
@Service
public class CategoryComponentService implements ICategoryComponentService{

	@Autowired
	private ICategoryComponentRepository categoryComponentRepository;
	
	@Override
	public void save(CategoryComponent categoryComponent) {
		categoryComponentRepository.save(categoryComponent);	
	}

	@Override
	public CategoryComponent findById(Long id) {
	
		return 	categoryComponentRepository.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		categoryComponentRepository.deleteById(id);
		
	}

	@Override
	public List<CategoryComponent> findAll() {
		return (List<CategoryComponent>)categoryComponentRepository.findAll();
	}

}
