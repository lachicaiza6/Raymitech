package raymitech.spring.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name="Comments")
@Entity
public class Comments implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_comments")
	private Long idComments;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="comments")
	private String comments;
	
	@DateTimeFormat(pattern="yy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name="date")
	private Calendar date;
	
	@JoinColumn(name="fk_id_post",referencedColumnName="id_post")
	@ManyToOne
	@JsonIgnore
	private Post post;
	
	public Long getIdComments() {
		return idComments;
	}

	public void setIdComments(Long idComments) {
		this.idComments = idComments;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
	
	
	
}
