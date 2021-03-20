package raymitech.spring.security.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import raymitech.spring.security.entities.Rol;
import raymitech.spring.security.enums.RolName;
import raymitech.spring.security.repository.IRolRepository;
import raymitech.spring.security.serviceImp.IRolService;

@Service
@Transactional
public class RolService implements IRolService{

		@Autowired
		IRolRepository rolRepository;

		@Override
		public Optional<Rol> getByRolName(RolName rolName) {
		
			return rolRepository.findByRolName(rolName);
		}

		@Override
		public void save(Rol rol) {
			rolRepository.save(rol);
			
		}
		
		
		
}
