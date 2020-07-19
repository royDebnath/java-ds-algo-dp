package com.patterns.structural.dao.interfaces;

import java.util.List;

import com.patterns.structural.dao.model.Books;

public interface BookDao {

	List<Books> getAllBooks();

	Books getBookByIsbn(int isbn);

	void saveBook(Books book);

	void deleteBook(Books book);
}