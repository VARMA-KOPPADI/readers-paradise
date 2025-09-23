package com.example.demo.bookService;

import java.util.List;

import com.example.demo.entity.Book;

public interface BookService {
	
	public String rigisterBook(Book book);
	public List<Book> fetchAllBooks();

}
