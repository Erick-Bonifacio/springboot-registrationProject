package com.demo.bonisApplication.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.demo.bonisApplication.entities.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private double price;
	private Date date;
	
	@OneToMany
	private List<Category> categories = new ArrayList<>();
	
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Client owner;
	
	public Order() {}

	public Order(Long id, String description, Double price, Date date, Status status, Client owner) {
		this.id = id;
		this.description = description;
		this.price = price;
		this.date = date;
		setOrderStatus(status);
		this.owner = owner;
	}
	
	public void setOrderStatus(Status status) {
		if(status != null) {
			this.status = status.getCode();
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setValue(Double value) {
		this.price = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getStatus() {
		return status;
	}
	
	public List<Category> getCategories() {
		return categories;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Client getOwner() {
		return owner;
	}

	public void setOwner(Client owner) {
		this.owner = owner;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
	
}
