package com.example.demo.bookcontroller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bookService.BookService;
import com.example.demo.entity.Book;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;
	@PostMapping("/postbook")
	public String postBook(@RequestBody Book book)
	{
		String stetus = bookService.rigisterBook(book);
		return stetus;
	}
	@GetMapping("getBooks")
	public List<Book> getAllbooks(){
		return bookService.fetchAllBooks();
	}
	

}
