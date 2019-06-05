package com.asiantech.application.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USER")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@NotEmpty()
	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "EMAIL", nullable = false, unique = true)
	@NotEmpty
	private String email;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;

	
	@Column(name = "PASSWORD", nullable = false)
	@NotEmpty
	@Size(min = 4)
	private String password;
	
	
	@ManyToOne
	@JoinColumn(name = "ROLE_ID")
	private RoleEntity role;

	@Column(name = "CREATED_DATE")
	private Date createdDate = new Date();

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate
	 *            the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the role
	 */
	public RoleEntity getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(RoleEntity role) {
		this.role = role;
	}

	
	public UserEntity(@NotEmpty String name, @NotEmpty String email, @NotEmpty @Size(min = 4) String password,
			RoleEntity role, Date createdDate) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.createdDate = createdDate;
	}

	public UserEntity() {
	}

}
