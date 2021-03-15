package raymitech.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name="ComponentItem")
@Entity
public class ComponentItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_component_item")
	private Long idComponentItem;
	
	@Column(name="type")
	private String type;
	
	@Column(name="title")
	private String title;
	
	@Column(name="content")
	private String content;
	
	@Column(name="url")
	private String url;
	
	@Column(name="img")
	private String img;
	
	@Column(name="video")
	private String video;

	@JoinColumn(name="fk_id_cat_component", referencedColumnName="id_cat_component")
	@ManyToOne
	@JsonIgnore
	private CategoryComponent categoryComponent;

	public Long getIdComponentItem() {
		return idComponentItem;
	}

	public void setIdComponentItem(Long idComponentItem) {
		this.idComponentItem = idComponentItem;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public CategoryComponent getCategoryComponent() {
		return categoryComponent;
	}

	public void setCategoryComponent(CategoryComponent categoryComponent) {
		this.categoryComponent = categoryComponent;
	}
	
	
	
	
	
}
