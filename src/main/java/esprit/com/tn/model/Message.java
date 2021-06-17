package esprit.com.tn.model;

import java.util.Date;

import javax.persistence.Entity;
@Entity
public class Message {
	
	private int id;
	private Date dateMessage;
	private String message;
	public Message(int id, String message) {
		super();
		this.id = id;
		this.dateMessage = new Date();
		this.message = message;
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
