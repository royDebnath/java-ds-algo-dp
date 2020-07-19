package com.patterns.structural.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.patterns.structural.dao.interfaces.BookDao;
import com.patterns.structural.dao.model.Books;

/*Data Access Object Pattern or DAO pattern is used to separate low level data accessing API 
 * or operations from high level business services. Following are the participants 
 * in Data Access Object Pattern.

Data Access Object Interface - This interface defines the standard operations
 to be performed on a model object(s).

Data Access Object concrete class - This class implements above interface. 
This class is responsible to get data from a data source which can be 
database / xml or any other storage mechanism.

Model Object or Value Object - This object is simple POJO containing get/set methods 
to store data retrieved using DAO class.

Implementation
We are going to create a Student object acting as a Model or Value Object.StudentDao 
is Data Access Object Interface.StudentDaoImpl is concrete class implementing Data Access Object
 Interface. DaoPatternDemo, our demo class, will use StudentDao to demonstrate the use of 
 Data Access Object pattern.

*/
public class BookDaoImpl implements BookDao {

    //list is working as a database
    private List<Books> books;

    public BookDaoImpl() {
        books = new ArrayList<>();
        books.add(new Books(1, "Java"));
        books.add(new Books(2, "Python"));
        books.add(new Books(3, "Android"));
    }

    @Override
    public List<Books> getAllBooks() {
        return books;
    }

    @Override
    public Books getBookByIsbn(int isbn) {
        return books.get(isbn);
    }

    @Override
    public void saveBook(Books book) {
        books.add(book);
    }

    @Override
    public void deleteBook(Books book) {
        books.remove(book);
    }
}