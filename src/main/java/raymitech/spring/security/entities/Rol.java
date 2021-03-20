package raymitech.spring.security.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import raymitech.spring.security.enums.RolName;

@Entity
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private RolName rolName;
	
	public Rol() {
		
	}
	
	public Rol(RolName rolName) {
		super();
		this.rolName = rolName;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RolName getRolNombre() {
		return rolName;
	}

	public void setRolNombre(RolName rolName) {
		this.rolName = rolName;
	}
	
	
	
	
}
