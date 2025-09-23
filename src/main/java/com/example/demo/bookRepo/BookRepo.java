package com.example.demo.bookRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

}
