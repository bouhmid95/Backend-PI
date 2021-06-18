package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Comment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String content;
	private Date publicationDate;

	public Comment(int id, String content) {
		super();
		this.id = id;
		this.content = content;
		this.publicationDate = new Date();

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

}
