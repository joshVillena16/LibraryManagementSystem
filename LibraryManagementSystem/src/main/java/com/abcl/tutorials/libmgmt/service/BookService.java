package com.abcl.tutorials.libmgmt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcl.tutorials.libmgmt.models.Book;
import com.abcl.tutorials.libmgmt.repository.BookRepository;

@Service("BookService")
public class BookService implements IBookService {

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public List<Book> getAllBooks(){
		ArrayList<Book> books = new ArrayList<>();
		Iterable<Book> itr = bookRepository.findAll();
		
		if(itr != null) {
			for(Book book : itr){
				books.add(book);
			}
		}
		
		return books;
	}
	
}
