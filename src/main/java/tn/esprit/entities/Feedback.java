package tn.esprit.entities;

import java.util.Date;

import javax.persistence.Entity;
@Entity
public class Feedback {
	
	private int id;
	private float rate;
	private Date dateRating;
	public Feedback(int id, float rate) {
		super();
		this.id = id;
		this.rate = rate;
		this.dateRating = new Date();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public Date getDateRating() {
		return dateRating;
	}
	public void setDateRating(Date dateRating) {
		this.dateRating = dateRating;
	}

}
