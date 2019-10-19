package com.ss.lms.service;

import com.ss.lms.dao.BookRepository;
import com.ss.lms.model.Author;
import com.ss.lms.model.Book;
import com.ss.lms.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
    public Book findByBookId(Integer bookId) {
        return bookRepository.getByBookId(bookId);
    }

    public void delete(Integer bookId){
        Book book = findByBookId(bookId);
        bookRepository.delete(book);
    }
    public List<Book> getByAuthor(Author author)
    {
        return bookRepository.getByAuthor(author);
    }
    public  List<Book> getByPublisher(Publisher publisher)
    {
        return bookRepository.getByPublisher( publisher);
    }

}
