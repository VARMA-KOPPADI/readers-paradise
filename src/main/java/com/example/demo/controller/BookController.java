package com.example.demo.controller;

import java.net.HttpURLConnection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.BookService;
import com.example.demo.entity.Book;
import com.example.demo.model.Constants;
import com.example.demo.model.ResponseMessage;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;

	@PostMapping("/postbook")
	public ResponseEntity<ResponseMessage> postBook(@RequestBody Book book) {
		boolean stetus = bookService.rigisterBook(book);
		return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constants.SUCCESS,
				"ONLINE BOOK REGISTERD SUCCESSFULLY", stetus));
	}
	

	@GetMapping("/getBooks")
	public List<Book> getAllbooks() {
		return bookService.fetchAllBooks();
	}

	@GetMapping("/getbyid")
	public ResponseEntity<ResponseMessage> getbyid(@RequestParam int i) {
		//return "book details : " + bookService.getbookbyid(i);
		  Book id = bookService.getBookById(i);
		  return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_ACCEPTED, Constants.SUCCESS, "data found with id "+id)); 

	}

}
