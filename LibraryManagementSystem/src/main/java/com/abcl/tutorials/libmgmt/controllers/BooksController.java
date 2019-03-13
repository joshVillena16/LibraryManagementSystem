package com.abcl.tutorials.libmgmt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abcl.tutorials.libmgmt.models.Book;
import com.abcl.tutorials.libmgmt.service.BookService;

@Controller
public class BooksController {

	@Autowired
	BookService bookService;
	
	@GetMapping("app/books")
	public ModelAndView getAllBooksPage() {
		List<Book> booksList = bookService.getAllBooks();
		
		ModelAndView mv = new ModelAndView("app/library/allBooks"); //from src/main/resources
		mv.addObject("books", booksList);
		return mv;
	}
}
