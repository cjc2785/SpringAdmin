package com.ss.lms.controller;


import com.ss.lms.model.*;
import com.ss.lms.service.*;
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
    @Autowired
    private LibraryBranchService libraryBranchService;
    @Autowired
    private BorrowerService borrowerService;
    @Autowired
    private BookService bookService;
    //AUTHOR//
    //AUTHOR//
    @PostMapping("/author/")
    public @Valid @ResponseBody Author addAuthor(@RequestBody Author authorDetails) {
        Author author = new Author();
        author.setAuthorName(authorDetails.getAuthorName());
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
    Publisher addPublisher(@RequestParam Publisher publisherDetails)
    {
        Publisher publisher = new Publisher();
        publisher.setPublisherName(publisherDetails.getPublisherName());
        publisher.setPublisherAddress(publisherDetails.getPublisherAddress());
        publisher.setPublisherPhone(publisherDetails.getPublisherPhone());
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




    ///LIBRARY BRANCH///
    ///LIBRARY BRANCH///
    ///LIBRARY BRANCH///
    ///LIBRARY BRANCH///
    @PostMapping("/branch/")
    public @Valid @ResponseBody
    LibraryBranch addLibraryBranch(@RequestBody LibraryBranch libraryBranchDetails)
    {
        LibraryBranch libraryBranch = new LibraryBranch();

        libraryBranch.setBranchName(libraryBranchDetails.getBranchName());
        libraryBranch.setBranchAddress(libraryBranchDetails.getBranchAddress());
        libraryBranchService.save(libraryBranch);
        return libraryBranch;
    }
    @GetMapping("/branch/{b_id}")
    public ResponseEntity<?> getLibraryBranchById(@PathVariable Integer b_id)
    {
        LibraryBranch libraryBranch = libraryBranchService.findById(b_id);
        return new ResponseEntity<LibraryBranch>(libraryBranch, HttpStatus.OK);
    }
    @PutMapping("/branch/{p_id}")
    public ResponseEntity<?> updateLibraryBranchById( @PathVariable Integer p_id ,@Valid @RequestBody LibraryBranch libraryBranchDetails)
    {
        LibraryBranch libraryBranch = libraryBranchService.findById(p_id);

        libraryBranch.setBranchName(libraryBranchDetails.getBranchName());
        libraryBranch.setBranchAddress(libraryBranchDetails.getBranchAddress());
        return  new ResponseEntity<LibraryBranch>(libraryBranch, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/branch/{b_id}")
    public ResponseEntity<?> deleteLibraryBranchById(@PathVariable Integer b_id)
    {
        libraryBranchService.delete(b_id);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/branches")
    public Iterable<LibraryBranch> getAllLibraryBranch()
    {
        return libraryBranchService.findAll();
    }


   ///Borrower///
   ///Borrower///
   ///Borrower///
   ///Borrower///
    @PostMapping("/borrower/")
    public @Valid @ResponseBody
    Borrower addLibraryBranch(@RequestBody Borrower borrowerDetails)
    {
        Borrower borrower = new Borrower();

        borrower.setName(borrowerDetails.getName());
        borrower.setAddress(borrowerDetails.getAddress());
        borrower.setPhone(borrowerDetails.getPhone());
        borrowerService.save(borrower);
        return borrower;
    }
    @GetMapping("/borrower/{br_id}")
    public ResponseEntity<?> getBorrowerByCardNo(@PathVariable Integer br_id)
    {
        Borrower borrower = borrowerService.findByCardNo(br_id);
        return new ResponseEntity<Borrower>(borrower, HttpStatus.OK);
    }
    @PutMapping("/borrower/{br_id}")
    public ResponseEntity<?> updateBorrowerByCardNo( @PathVariable Integer br_id ,@Valid @RequestBody Borrower borrowerDetails)
    {
        Borrower borrower = borrowerService.findByCardNo(br_id);
        borrower.setName(borrowerDetails.getName());
        borrower.setAddress(borrowerDetails.getAddress());
        borrower.setPhone(borrowerDetails.getPhone());
        borrowerService.save(borrower);
        return  new ResponseEntity<Borrower>(borrower, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/borrower/{br_id}")
    public ResponseEntity<?> deleteBorrowerByCardNo(@PathVariable Integer br_id)
    {
        borrowerService.delete(br_id);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/borrowers")
    public Iterable<Borrower> getAllBorrowers()
    {
        return borrowerService.findAll();
    }




    ///Book///
    ///Book///
    ///Book///
    ///Book///
    @PostMapping("/book/")
    public @Valid @ResponseBody
    Book addBook(@RequestBody Book bookDetails)
    {
        Book book = new Book();
        book.setTitle(bookDetails.getTitle());
        book.setAuthId(bookDetails.getAuthId());
        book.setPubId(bookDetails.getPubId());
        bookService.save(book);
        return book;
    }
    @GetMapping("/book/{bk_id}")
    public ResponseEntity<?> getBookById(@PathVariable Integer bk_id)
    {
        Book book = bookService.findByBookId(bk_id);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }
    @PutMapping("/book/{bk_id}")
    public ResponseEntity<?> updateBookById( @PathVariable Integer bk_id ,@Valid @RequestBody Book bookDetails)
    {
        Book book = bookService.findByBookId(bk_id);
        book.setTitle(bookDetails.getTitle());
        bookService.save(book);
        return  new ResponseEntity<Book>(book, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/book/{bk_id}")
    public ResponseEntity<?> deleteBookById(@PathVariable Integer bk_id)
    {
        bookService.delete(bk_id);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/books")
    public Iterable<Book> getAllBooks()
    {
        return bookService.findAll();
    }

}
