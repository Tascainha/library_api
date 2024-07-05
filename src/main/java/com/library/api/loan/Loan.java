package com.library.api.loan;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.library.api.book.Book;
import com.library.api.user.User;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "loans")
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(optional = false, targetEntity = User.class)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private Long userId;

	@ManyToOne(optional = false, targetEntity = Book.class)
	@JoinColumn(name = "book_id", referencedColumnName = "id")
	private Long bookId;

	@CreationTimestamp
	@Column(updatable = false)
	private Date createdAt;

	private Date returnDate;

	@Nullable
	@UpdateTimestamp
	private Date returnedAt;

	protected Loan() {}

	public Loan(Long userId, Long bookId) {
		this.userId = userId;
		this.bookId = bookId;
		this.returnDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7);
	}

	public Long getId() {
		return id;
	}

	public Long getUserId() {
		return userId;
	}

	public Long getBookId() {
		return bookId;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public Date getReturnedAt() {
		return returnedAt;
	}

	public void setReturnedAt(Date returnedAt) {
		this.returnedAt = returnedAt;
	}
}
