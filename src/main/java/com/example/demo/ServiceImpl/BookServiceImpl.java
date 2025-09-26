package com.example.demo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.BookRepo;
import com.example.demo.Service.BookService;
import com.example.demo.entity.Book;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepo bookRepo;

	@Override
	public boolean rigisterBook(Book book) {
		Book save = bookRepo.save(book);
		System.out.println(save + "varma");// Saves book into DB
		return true;
	}

	@Override
	public List<Book> fetchAllBooks() {
		return bookRepo.findAll();
	}

	@Override
	public Book getBookById(int id) {
		return bookRepo.findById(id).orElseThrow(()-> new RuntimeException("Book not found with Id : "+id)); 
	}

}
