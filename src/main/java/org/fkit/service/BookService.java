package org.fkit.service;

import java.util.List;

import org.fkit.domain.Book;
import org.fkit.domain.Category;




public interface BookService {
    
    List<Category> getAllCategories();
    Category getCategory(int id);
    List<Book> getAllBooks();
    Book save(Book book);
    Book update(Book book);
    Book get(long id);
    long getNextId();

}
