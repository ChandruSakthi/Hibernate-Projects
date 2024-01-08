package org.jsp.OneToMany2.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Merchant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Column(nullable = false)
	private String Name;
	@Column(nullable = false, unique = true)
	private long Phone;
	@Column(nullable = false, unique = true)
	private String Email;
	@Column(nullable = false, unique = true)
	private String Gst;
	@Column(nullable = false, unique = true)
	private String Password;
	@OneToMany(mappedBy = "merchant")
	private List<Product> products;

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

	public long getPhone() {
		return Phone;
	}

	public void setPhone(long phone) {
		Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getGst() {
		return Gst;
	}

	public void setGst(String gst) {
		Gst = gst;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
