package com.ss.lms.controller;


import com.ss.lms.model.Author;
import com.ss.lms.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/author/")
    public @Valid @ResponseBody Author addAuthor(@RequestParam String authorName) {
        Author author = new Author();
        author.setAuthorName(authorName);
        authorService.save(author);
        return author;
    }
    @GetMapping("/authors")
    public Iterable<Author> getAllPTs() {
        return authorService.findAll();
    }


    @GetMapping("/{a_id}")
    public ResponseEntity<?> getPTById(@PathVariable Integer a_id) {
        Author author = authorService.findById(a_id);
        return new ResponseEntity<Author>(author, HttpStatus.OK);
    }
    @DeleteMapping("/author/{a_id}")
    public ResponseEntity<?> deleteProjectTask(@PathVariable Integer a_id){
        authorService.delete(a_id);
        return new ResponseEntity<String>("Author has Been Deleted", HttpStatus.NO_CONTENT);
    }


}
