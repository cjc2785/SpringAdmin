package com.ss.lms.dao;

import com.ss.lms.model.Author;
import com.ss.lms.model.Book;
import com.ss.lms.model.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BookRepository extends CrudRepository<Book, Map<Author,Publisher>> {
    Book getByBookId(Integer bookId);
    List<Book> getByAuthor(Author author);
    List<Book> getByPublisher(Publisher publisher);

}

