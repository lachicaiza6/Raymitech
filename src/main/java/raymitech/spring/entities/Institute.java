package raymitech.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="Institute")
@Entity
public class Institute implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_institute")
	private Long idInstitute;
	
	@Column(name="name")
	private String name;
	
	@Column(name="domain")
	private String domain;
	
	@Column(name="cellphone")
	private String cellphone;
	
	@Column(name="email")
	private String email;
	
	@Column(name="img")
	private String img;

	@OneToMany(mappedBy="institute",fetch=FetchType.LAZY)
	private List<User> user;
	
	/*@OneToMany(mappedBy="institute",fetch=FetchType.LAZY)
	private List<CategoryComponent> categoryComponent;*/
	
	public Institute() {
		super();
	}
	public Long getIdInstitute() {
		return idInstitute;
	}

	public void setIdInstitute(Long idInstitute) {
		this.idInstitute = idInstitute;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}


	public List<User> getUser() {
		return user;
	}


	public void setUser(List<User> user) {
		this.user = user;
	}


	/*public List<CategoryComponent> getCategoryComponent() {
		return categoryComponent;
	}


	public void setCategoryComponent(List<CategoryComponent> categoryComponent) {
		this.categoryComponent = categoryComponent;
	}*/
	
	
	
	
}
