package com.ss.lms.service;


import com.ss.lms.dao.AuthorRepository;
import com.ss.lms.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author save(Author author) {
//        if (author.getAuthorName() == null || author.getAuthorName()=="") {
//            author.setAuthorName("TO_DO");
//        }
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
}
