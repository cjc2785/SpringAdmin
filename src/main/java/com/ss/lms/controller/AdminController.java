package com.ss.lms.controller;


import com.ss.lms.model.Author;
import com.ss.lms.model.Publisher;
import com.ss.lms.service.AuthorService;
import com.ss.lms.service.PublisherService;
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
    @Autowired
    private PublisherService publisherService;

    //AUTHOR//
    //AUTHOR//
    @PostMapping("/author/")
    public @Valid @ResponseBody Author addAuthor(@RequestParam String authorName) {
        Author author = new Author();
        author.setAuthorName(authorName);
        authorService.save(author);
        return author;
    }
    @PutMapping("/author/{p_id}")
    public ResponseEntity<?> updateAuthorById( @PathVariable Integer p_id ,@Valid @RequestBody Author authorDetails)
    {
        Author author = authorService.findById(p_id);
        author.setAuthorName(authorDetails.getAuthorName());
        authorService.save(author);
        return  new ResponseEntity<Author>(author, HttpStatus.ACCEPTED);
    }
    @GetMapping("/authors")
    public Iterable<Author> getAllPTs() {
        return authorService.findAll();
    }

    @GetMapping("/author/{a_id}")
    public ResponseEntity<?> getAuthorById(@PathVariable Integer a_id) {
        Author author = authorService.findById(a_id);
        return new ResponseEntity<Author>(author, HttpStatus.OK);
    }
    @DeleteMapping("/author/{a_id}")
    public ResponseEntity<?> deleteAuthorById(@PathVariable Integer a_id){
        authorService.delete(a_id);
        return new ResponseEntity<String>( HttpStatus.NO_CONTENT);
    }



    //Publisher//
    //Publisher//
    @PostMapping("/publisher/")
    public @Valid @ResponseBody
    Publisher addPublisher(@RequestParam String publisherName,
                           String publisherAddress, String publisherPhone)
    {
        Publisher publisher = new Publisher();
        publisher.setPublisherName(publisherName);
        publisher.setPublisherAddress(publisherAddress);
        publisher.setPublisherPhone(publisherPhone);
        publisherService.save(publisher);
        return publisher;
    }
    @GetMapping("/publisher/{p_id}")
    public ResponseEntity<?> getPublisherById(@PathVariable Integer p_id)
    {
        Publisher publisher = publisherService.findById(p_id);
        return new ResponseEntity<Publisher>(publisher, HttpStatus.OK);
    }
    @PutMapping("/publisher/{p_id}")
    public ResponseEntity<?> updatePublisherById( @PathVariable Integer p_id ,@Valid @RequestBody Publisher publisherDetails)
    {
        Publisher publisher = publisherService.findById(p_id);
        publisher.setPublisherName(publisherDetails.getPublisherName());
        publisher.setPublisherPhone(publisherDetails.getPublisherPhone());
        publisher.setPublisherAddress(publisherDetails.getPublisherAddress());
        return  new ResponseEntity<Publisher>(publisher, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/publisher/{p_id}")
    public ResponseEntity<?> deletePublisherById(@PathVariable Integer p_id)
    {
        publisherService.delete(p_id);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/publishers")
    public Iterable<Publisher> getAllPublishers()
    {
        return publisherService.findAll();
    }

}
