package com.ss.lms.dao;

import com.ss.lms.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    Book getByBookId(Integer bookId);
}
