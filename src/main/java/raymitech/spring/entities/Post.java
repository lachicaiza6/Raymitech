package raymitech.spring.entities;

import java.io.Serializable;
import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name="Post")
@Entity
public class Post implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_post")
	private Long idPost;
	
	@Column(name="name")
	private String name;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="date")
	@DateTimeFormat(pattern="yy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Calendar date;
	
	@JoinColumn(name="fk_user", referencedColumnName="id_user")
	@ManyToOne
	@JsonIgnore
	private User user;
	
	@JoinColumn(name="fk_category", referencedColumnName="id_category")
	@ManyToOne
	@JsonIgnore
	private Category category;
	
	@OneToMany(mappedBy="post",fetch=FetchType.LAZY)
	private List<Comments> comments;
	
	@OneToMany(mappedBy="post",fetch=FetchType.LAZY)
	private List<CategoryComponent> categoryComponent;

	public Long getIdPost() {
		return idPost;
	}

	public void setIdPost(Long idPost) {
		this.idPost = idPost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	public List<CategoryComponent> getCategoryComponent() {
		return categoryComponent;
	}

	public void setCategoryComponent(List<CategoryComponent> categoryComponent) {
		this.categoryComponent = categoryComponent;
	}
	
	
	

	
	
}
