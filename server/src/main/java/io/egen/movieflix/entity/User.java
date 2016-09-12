package io.egen.movieflix.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "User.findByUsername", query = "SELECT u from User u where u.username=:username"),
	@NamedQuery(name = "User.findByCredentials", query = "SELECT u from User u where u.username=:username AND u.password=:password")
})
public class User {
	@Id
	private String id;
	
	@Column(unique = true)
	private String username;
	
	private String password;
	private String firstName;
	private String lastName;
	
	@Column(unique = true)
	private String email;
	
	public User() {
		id = UUID.randomUUID().toString();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
