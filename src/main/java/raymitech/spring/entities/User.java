package raymitech.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name="User")
@Entity

public class User  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_user")
	private Long idUsers;
	
	@Column(name="name")
	private String name;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="email")
	private String email;
	

	
	@JoinColumn(name="fk_institute", referencedColumnName="id_institute")
	@ManyToOne	
	@JsonIgnore
	private Institute institute;
	
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	private List<Post> post;
	
	public User() {
		super();
	}
	public User(Long idUser) {
		this.idUsers=idUser;
	}
	public Long getIdUsers() {
		return idUsers;
	}
	public void setIdUsers(Long idUsers) {
		this.idUsers = idUsers;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Institute getInstitute() {
		return institute;
	}
	public void setInstitute(Institute institute) {
		this.institute = institute;
	}
	public List<Post> getPost() {
		return post;
	}
	public void setPost(List<Post> post) {
		this.post = post;
	}
	
	
	
}
