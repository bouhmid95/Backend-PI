package tn.esprit.entities;

import java.util.Date;

public class Order {
	
	private int id;
	private String title;
	private Date orderDate;
	private String status;
	private String typePaiement;
	
	
	public Order(String title, Date orderDate) {
		super();
		this.title = title;
		this.orderDate = orderDate;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTypePaiement() {
		return typePaiement;
	}

	public void setTypePaiement(String typePaiement) {
		this.typePaiement = typePaiement;
	}
	
	
	
	
	

}
