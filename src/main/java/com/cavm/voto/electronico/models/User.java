package com.cavm.voto.electronico.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class User  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@NotEmpty
	@Column(nullable = true)
	private String name;
	
	//@NotEmpty
	@Column(nullable = true)
	private String last_name;
	
	@NotEmpty
	@Column(nullable = false, unique = true, length = 30)
	private String username;
	
	@NotEmpty
	@Column(nullable = false, length = 60)
	private String password;
	
	
	@Column(nullable = false)
	private Boolean state = true;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at" ,nullable = true)
	private Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name ="update_at" ,nullable = true)
	private Date updateAt;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<RoleUser> roles;

	public List<RoleUser> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleUser> roles) {
		this.roles = roles;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
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

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

}
