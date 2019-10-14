package com.ss.lms.dao;

import com.ss.lms.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {
    Author getByAuthorId(Integer Id);


}
