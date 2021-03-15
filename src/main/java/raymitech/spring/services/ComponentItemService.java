package raymitech.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import raymitech.spring.entities.ComponentItem;
import raymitech.spring.repository.IComponentItemRepository;
import raymitech.spring.services.interfaces.IComponentItemService;

@Service
public class ComponentItemService implements IComponentItemService{

	@Autowired
	private IComponentItemRepository componentItemRepository;
	
	@Override
	public void save(ComponentItem componentItem) {
		componentItemRepository.save(componentItem);
		
	}

	@Override
	public ComponentItem findById(Long id) {
		
		return componentItemRepository.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		componentItemRepository.deleteById(id);
		
	}

	@Override
	public List<ComponentItem> findAll() {
	
		return (List<ComponentItem>)componentItemRepository.findAll();
	}

}
