package raymitech.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import raymitech.spring.entities.Institute;
import raymitech.spring.repository.IInstituteRepository;
import raymitech.spring.services.interfaces.IInstituteService;

@Service
public class InstituteService implements IInstituteService {

	@Autowired
	private IInstituteRepository instituterepository;
	
	@Override
	public void save(Institute institute) {
		instituterepository.save(institute);		
	}

	@Override
	public Institute findById(Long id) {
		
		return instituterepository.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		instituterepository.deleteById(id);
		
	}

	@Override
	public List<Institute> findAll() {
		
		return (List<Institute>)instituterepository.findAll();
	}

}
