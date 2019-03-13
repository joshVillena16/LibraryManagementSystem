package com.abcl.tutorials.libmgmt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abcl.tutorials.libmgmt.models.Book;
import com.abcl.tutorials.libmgmt.repository.BookRepository;


@Controller
public class AppController {
	
	@Autowired
	BookRepository bookRepository;
	
	@GetMapping("/app")
	public ModelAndView getIndexPage() {
		Iterable<Book> itr = bookRepository.findAll();
		for(Book book : itr) {
			System.out.println(book.getBookTitle());
		}
		
		ModelAndView mv = new ModelAndView("app/index");
		return mv;
	}
}
