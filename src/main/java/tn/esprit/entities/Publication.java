package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Publication implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String content;
	private Date publicationDate;
	private int nbLike;
	private int nbDisLike;
	@OneToMany(mappedBy = "publication")
	private List<Comment> comments;
	@ManyToOne
	private User user;

	public Publication(int id, String content, Date publicationDate, int nbLike, int nbDisLike, List<Comment> comments,
			User user) {
		super();
		this.id = id;
		this.content = content;
		this.publicationDate = publicationDate;
		this.nbLike = nbLike;
		this.nbDisLike = nbDisLike;
		this.comments = comments;
		this.user = user;
	}

	public Publication() {
		super();
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public int getNbLike() {
		return nbLike;
	}

	public void setNbLike(int nbLike) {
		this.nbLike = nbLike;
	}

	public int getNbDisLike() {
		return nbDisLike;
	}

	public void setNbDisLike(int nbDisLike) {
		this.nbDisLike = nbDisLike;
	}

}
