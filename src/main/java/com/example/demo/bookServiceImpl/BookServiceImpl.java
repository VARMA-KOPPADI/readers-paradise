package com.example.demo.bookServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bookRepo.BookRepo;
import com.example.demo.bookService.BookService;
import com.example.demo.entity.Book;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
    private BookRepo bookRepo;

    @Override
    public String rigisterBook(Book book) {
        bookRepo.save(book); // Saves book into DB
        return "Successfully Registered";
    }
    @Override
    public List<Book> fetchAllBooks() {
    	return bookRepo.findAll();
    }

    

}
