package com.abcl.tutorials.libmgmt.repository;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.abcl.tutorials.libmgmt.models.Book;

import org.springframework.data.repository.CrudRepository;

@Repository
@Transactional
public interface BookRepository extends CrudRepository<Book, Long>{

}
