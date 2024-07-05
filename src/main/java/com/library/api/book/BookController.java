package com.library.api.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@GetMapping
	public Iterable<Book> list() {
		return bookRepository.findAll();
	}

	@GetMapping("/{id}")
	public Book findById(@PathVariable Long id) {
		return bookRepository.findById(id).orElse(null);
	}

	@GetMapping(params = "isbn")
	public Iterable<Book> findByIsbn(@RequestParam String isbn) {
		return bookRepository.findByIsbn(isbn);
	}

	@GetMapping(params = "title")
	public Iterable<Book> findByTitle(@RequestParam String title) {
		return bookRepository.findByTitle(title);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Book save(@RequestBody Book book) {
		return bookRepository.saveAndFlush(book);
	}
}

