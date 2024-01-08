package org.jsp.OneToMany2.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Column(nullable = false)
	private String Name;
	@Column(nullable = false)
	private String Brand;
	@Column(nullable = false)
	private String Category;
	@Column(nullable = false)
	private String Description;
	@Column(nullable = false)
	private double Cost;
	@Column(nullable = false, unique = true)
	private String URL;
	@ManyToOne
	@JoinColumn(name = "Merchant_Id")
	private Merchant merchant;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public double getCost() {
		return Cost;
	}

	public void setCost(double cost) {
		Cost = cost;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

}
