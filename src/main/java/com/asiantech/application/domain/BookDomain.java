package com.asiantech.application.domain;

import java.util.Date;

import com.asiantech.application.entity.BookEntity;

public class BookDomain {
    
	private Long id;
    
    private String title;
    
    private String author;
	
	private String description;

	public BookDomain(Long id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}
	
	public BookDomain(Long id, String title, String description, String author) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.author = author;
	}

	public BookDomain() {
	}

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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
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
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BookEntity toEntity() {
		return new BookEntity(title, author, description, new Date(), null);
	}
	
}
