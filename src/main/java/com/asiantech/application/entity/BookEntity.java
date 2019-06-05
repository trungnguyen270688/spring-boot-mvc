package com.asiantech.application.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.asiantech.application.domain.BookDomain;

@Entity
@Table(name = "BOOK")
public class BookEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "TITLE", nullable = false)
	@NotEmpty
	private String title;
	
	@Column(name = "AUTHOR", nullable = false)
	@NotEmpty
	private String author;

	@Column(name = "DESCRIPTION")
	private String description;


	@Column(name = "CREATED_AT", nullable = false)
	private Date createdDate = new Date();


	@Column(name = "UPDATED_AT")
	private Date updatedDate;

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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @return the updatedDate
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate
	 *            the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BookDomain toDomain() {
		return new BookDomain(id, title, description, author);
	}

	
	

	public BookEntity(@NotEmpty String title, @NotEmpty String author, String description, Date createdDate,
			Date updatedDate) {
		super();
		this.title = title;
		this.author = author;
		this.description = description;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public BookEntity() {
	}

}
