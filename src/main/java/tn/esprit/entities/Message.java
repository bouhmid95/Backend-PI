package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Message implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date dateMessage;
	private String message;
	@ManyToOne
	private User userSour;
	@ManyToOne
	private User userDest;

	public Message(int id, Date dateMessage, String message, User userSour, User userDest) {
		super();
		this.id = id;
		this.dateMessage = dateMessage;
		this.message = message;
		this.userSour = userSour;
		this.userDest = userDest;
	}

	public Message() {
		super();
	}

	public User getUserSour() {
		return userSour;
	}

	public void setUserSour(User userSour) {
		this.userSour = userSour;
	}

	public User getUserDest() {
		return userDest;
	}

	public void setUserDest(User userDest) {
		this.userDest = userDest;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateMessage() {
		return dateMessage;
	}

	public void setDateMessage(Date dateMessage) {
		this.dateMessage = dateMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
