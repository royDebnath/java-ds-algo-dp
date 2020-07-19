package com.patterns.structural.dao.impl;

import com.patterns.structural.dao.interfaces.BookDao;
import com.patterns.structural.dao.model.Books;

public class AccessBook {

    public static void main(String[] args) {

        BookDao bookDao = new BookDaoImpl();

        for (Books book : bookDao.getAllBooks()) {
            System.out.println("Book ISBN : " + book.getIsbn());
        }

        //update student
        Books book = bookDao.getAllBooks().get(1);
        book.setBookName("Algorithms");
        bookDao.saveBook(book);
    }
}