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

@Table(name="CategoryComponent")
@Entity
public class CategoryComponent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cat_component")
	private Long idCatComponent;
	
	@Column(name="position")
	private Long position;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;


	@JoinColumn(name="fk_id_post",referencedColumnName="id_post")
	@ManyToOne
	@JsonIgnore
	private Post post;
	
		
	@OneToMany(mappedBy="categoryComponent",fetch=FetchType.LAZY)
	private List<ComponentItem> componentItem;
	
	/*@JoinColumn(name="fk_id_institute", referencedColumnName="id_institute")
	@ManyToOne
	@JsonIgnore
	private Institute institute;*/

	public Long getIdCatComponent() {
		return idCatComponent;
	}

	public void setIdCatComponent(Long idCatComponent) {
		this.idCatComponent = idCatComponent;
	}

	public Long getPosition() {
		return position;
	}

	public void setPosition(Long position) {
		this.position = position;
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

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public List<ComponentItem> getComponentItem() {
		return componentItem;
	}

	public void setComponentItem(List<ComponentItem> componentItem) {
		this.componentItem = componentItem;
	}

	/*public Institute getInstitute() {
		return institute;
	}

	public void setInstitute(Institute institute) {
		this.institute = institute;
	}*/
	
	
	
}
