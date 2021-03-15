package raymitech.spring.services.interfaces;

import java.util.List;

import raymitech.spring.entities.Institute;

public interface IInstituteService {

	public void save(Institute institute);
	public Institute findById(Long id);
	public void delete(Long id);
	public List<Institute> findAll();
}
