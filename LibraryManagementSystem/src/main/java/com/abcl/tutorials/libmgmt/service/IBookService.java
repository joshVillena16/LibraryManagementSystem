package com.abcl.tutorials.libmgmt.service;

import java.util.List;
import java.util.ArrayList;

import com.abcl.tutorials.libmgmt.models.Book;

public interface IBookService {
	
	public default List<Book> getAllBooks(){
		return new ArrayList<>();
	}
}
