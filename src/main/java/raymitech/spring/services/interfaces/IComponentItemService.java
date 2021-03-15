package raymitech.spring.services.interfaces;

import java.util.List;

import raymitech.spring.entities.ComponentItem;

public interface IComponentItemService {

	public void save(ComponentItem componentItem);
	public ComponentItem findById(Long id);
	public void delete(Long id);
	public List<ComponentItem> findAll();
	
}
