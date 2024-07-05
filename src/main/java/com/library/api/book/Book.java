package com.library.api.book;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue
	private Long id;

	private String isbn;
	private String title;
	private String status;

	protected Book() {}

	public Book(String isbn, String title) {
		this.isbn = isbn;
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}
}
