package com.library.api.book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	@Query("SELECT b FROM Book b WHERE b.isbn = :isbn")
	List<Book> findByIsbn(String isbn);

	@Query("SELECT b FROM Book b WHERE b.title = :title")
	List<Book> findByTitle(String title);
}
