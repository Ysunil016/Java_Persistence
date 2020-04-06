package com.Hibernate.Mysql.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Declaring Table Name w.r.t Database Name
@Entity
@Table(name = "user_info", catalog = "jpa_hibernate")
public class User_Info {

	@Id
	@Column(name = "username", length = 20)
	private String username;

	private String city;

	private String country;

	// JPA Require Constructor to Defined
	public User_Info() {
	}

	public String getUsername() {
		return username;
	}

	public User_Info setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getCity() {
		return city;
	}

	public User_Info setCity(String city) {
		this.city = city;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public User_Info setCountry(String country) {
		this.country = country;
		return this;
	}

}
