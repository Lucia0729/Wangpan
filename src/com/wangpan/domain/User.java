package com.wangpan.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name="user")
@NamedQuery(name="USERQuery",query="from User")
public class User {
	
	
	private Integer userId;
	private String username;
	private String password;
	private Long Idcard;
	
	
	public User() {
		super();
	}
	
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	

	public User(int userId, String username, String password, long Idcard) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.Idcard = Idcard;
	}


	@Id
	@Column(name="userId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@Column(name="username")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}


	public Long getIdcard() {
		return Idcard;
	}


	public void setIdcard(Long idcard) {
		Idcard = idcard;
	}
	
	
	
}
