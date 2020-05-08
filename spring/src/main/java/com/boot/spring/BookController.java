package com.boot.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {

	@GetMapping("/books")
	public List<Book> getBooks(){
		return Arrays.asList(
				new Book(1, "Mastering spring 5", "Well Bush"),
				new Book(2, "Mastering spring 4", "Grill Rush"),
				new Book(3, "Mastering LockIns", "Bella Rush"),
				new Book(4, "Servlet Routines", "Lewis Rush")
		);
	}
}
