package com.Hibernate.Mysql.Bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "users", catalog = "jpa_hibernate")
public class User {

	@Id
	@Column(name = "username", length = 20)
	private String username;

	@Column(name = "password")
	private String password;

// One2One Table Mapping Here
//	@JoinColumn(name = "id", referencedColumnName = "id", table = "user_info")

	// One to One Mapping

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "username", referencedColumnName = "username")
	private User_Info user_info;

	// One to Many Mapping

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "username", referencedColumnName = "username")
	private List<User_Log> user_log;

	public User() {
	}

//	public List<User_Log> getUser_log() {
//		return user_log;
//	}
//
//	public void setUser_log(List<User_Log> user_log) {
//		this.user_log = user_log;
//	}

	public User_Info getUser_info() {
		return user_info;
	}

	public List<User_Log> getUser_log() {
		return user_log;
	}

	public User setUser_log(List<User_Log> user_log) {
		this.user_log = user_log;
		return this;
	}

	public User setUser_info(User_Info user_info) {
		this.user_info = user_info;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public User setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

}
