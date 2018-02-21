package com.niit.shop.shopback.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="UserTable")
public class User{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotNull(message = "Name can't be empty")
	private String userName;
	
//	@OneToMany
//	@JoinColumn(name="email")
	@Column(name="email",unique=true)
	@NotEmpty
	@Pattern(regexp=".+@.+\\.[a-z]+", message="Give valid mail e.g.{name@abc.com}")
	private String email;
	
	@Size(min = 10, max = 10, message="Give valid number")
	private String mobile;
	
	@NotEmpty(message="Enter valid address")
	private String address;
	
	@NotEmpty(message="Enter your country")
	private String country;
	
	@NotEmpty(message = "Please enter your password")
    @Size(min = 6, max = 10, message = "Your password must between 6 and 10 characters")
	private String password;
	
	private String role;
	private boolean enabled;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
