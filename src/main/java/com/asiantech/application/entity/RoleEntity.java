package com.asiantech.application.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "ROLE")
public class RoleEntity {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
    private Long id;
    
	@Column(name="NAME", nullable = false, unique = true)
    @NotEmpty
    private String name;

    @OneToMany(mappedBy = "role")
    private List <UserEntity> users;
	
    @Column(name="CREATED_DATE")
	private Date createdDate = new Date();
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
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
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the users
	 */
	public List<UserEntity> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public RoleEntity(Long id, @NotEmpty String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public RoleEntity() {
	}
	
}
