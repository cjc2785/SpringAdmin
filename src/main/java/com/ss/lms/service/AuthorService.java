package com.ss.lms.service;


import com.ss.lms.dao.AuthorRepository;
import com.ss.lms.dao.BookRepository;
import com.ss.lms.model.Author;
import com.ss.lms.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }
    public Author findById(Integer Id) {
        return authorRepository.getByAuthorId(Id);
    }

    public void delete(Integer authorId){
        Author author = findById(authorId);
        authorRepository.delete(author);
    }
    public Iterable<Book> getBooks(Author author)
    {
        return bookRepository.getByAuthor(author);
    }
}
