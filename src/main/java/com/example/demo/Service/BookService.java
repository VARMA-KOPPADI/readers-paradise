package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Book;

public interface BookService {
	
	public boolean rigisterBook(Book book);
	public List<Book> fetchAllBooks();
	
	public Book getBookById(int i);

}
