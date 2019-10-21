package com.ss.lms.controller;


import com.ss.lms.model.*;
import com.ss.lms.service.*;
<<<<<<< HEAD
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.expression.spel.ast.NullLiteral;
=======
>>>>>>> admin
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.Valid;
<<<<<<< HEAD
import java.util.List;
import java.util.Optional;
@EnableDiscoveryClient
=======
import java.util.Optional;

>>>>>>> admin
@RestController
@RequestMapping("/lms/admin/")
public class AdminController {

<<<<<<< HEAD

=======
>>>>>>> admin
    private final AuthorService authorService;
    private final PublisherService publisherService;
    private final LibraryBranchService libraryBranchService;
    private final BorrowerService borrowerService;
    private final BookService bookService;
    private final BookLoansService bookLoansService;
<<<<<<< HEAD
    private final Book emptyBook = new Book();
    private final Author emptyAuthor = new Author();
    private final Borrower emptyBorrower = new Borrower();
    private final BookLoans emptyBookLoans = new BookLoans();
    private final LibraryBranch emptyLibraryBranch = new LibraryBranch();
    private final Publisher emptyPublisher = new Publisher();
=======

>>>>>>> admin
    public AdminController(AuthorService authorService, PublisherService publisherService, LibraryBranchService libraryBranchService,
                           BorrowerService borrowerService, BookService bookService, BookLoansService bookLoansService, BookLoansService bookLoansService1) {

        this.authorService = authorService;
        this.publisherService = publisherService;
        this.libraryBranchService = libraryBranchService;
        this.borrowerService = borrowerService;
        this.bookService = bookService;
        this.bookLoansService = bookLoansService1;
    }
<<<<<<< HEAD
    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody String handleResourceNotFound( ) {return "Could not find resource";}

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handle(Exception e) {
        return "invalid request";
    }
    //AUTHOR//
    //AUTHOR//
    @PostMapping("/authors")
    public @Valid @ResponseBody ResponseEntity<?> addAuthor(@RequestBody Author authorDetails) {
       if(authorDetails != null)
       {
           Author author = new Author();
           author.setAuthorName(authorDetails.getAuthorName());
           authorService.save(author);
           return new ResponseEntity<Author>(author, HttpStatus.CREATED);
       }
       else {
           return new ResponseEntity<Author>(emptyAuthor, HttpStatus.BAD_REQUEST);
       }

=======

    //AUTHOR//
    //AUTHOR//
    @PostMapping("/author/")
    public @Valid @ResponseBody ResponseEntity<?> addAuthor(@RequestBody Author authorDetails) {
        Author author = new Author();
        author.setAuthorName(authorDetails.getAuthorName());
        authorService.save(author);
        return new ResponseEntity<Author>(author, HttpStatus.CREATED);
>>>>>>> admin
    }
    @PutMapping("/authors/{a_id}")
    public ResponseEntity<?> updateAuthorById( @PathVariable int a_id ,@Valid @RequestBody Author authorDetails)
    {
                Author author = authorService.findById(a_id);
                if (author == null)
                {
                    return  new ResponseEntity<>(emptyAuthor,HttpStatus.NOT_FOUND);
                }
                author.setAuthorName(authorDetails.getAuthorName());
                authorService.save(author);
                return  new ResponseEntity<Author>(author, HttpStatus.ACCEPTED);

        }

    @GetMapping("/authors")
    public Iterable<Author> getAllPTs() {
        return authorService.findAll();
    }

    @GetMapping("/authors/{a_id}")
    public ResponseEntity<?> getAuthorById(@PathVariable Integer a_id) {

        Author author = authorService.findById(a_id);
        if (author == null)
        {
            return new ResponseEntity<>(emptyAuthor,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Author>(author, HttpStatus.OK);
    }
    @DeleteMapping("/authors/{a_id}")
    public ResponseEntity<?> deleteAuthorById(@PathVariable Integer a_id){
        authorService.delete(a_id);
        return new ResponseEntity<String>( HttpStatus.NO_CONTENT);
    }
    @GetMapping("authors/{a_id}/books")
    private @ResponseBody
    List<Book> getBooks(@PathVariable Integer a_id)
    {
        Author author = authorService.findById(a_id);

<<<<<<< HEAD
        return bookService.getByAuthor(author);

    }

=======
>>>>>>> admin
    //Publisher//
    //Publisher//
    @PostMapping("/publishers/")
    public @Valid @ResponseBody
    ResponseEntity<?> addPublisher(@RequestBody Publisher publisherDetails)
    {
        Publisher publisher = new Publisher();
        publisher.setPublisherName(publisherDetails.getPublisherName());
        publisher.setPublisherAddress(publisherDetails.getPublisherAddress());
        publisher.setPublisherPhone(publisherDetails.getPublisherPhone());
        publisherService.save(publisher);
        return new ResponseEntity<Publisher>(publisher, HttpStatus.CREATED);
    }
    @GetMapping("/publishers/{p_id}")
    public ResponseEntity<?> getPublisherById(@PathVariable Integer p_id)
    {
        Publisher publisher = publisherService.findById(p_id);
        if(publisher == null)
        {
            return new ResponseEntity<Publisher>(emptyPublisher, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Publisher>(publisher, HttpStatus.OK);
    }
    @PutMapping("/publishers/{p_id}")
    public ResponseEntity<?> updatePublisherById( @PathVariable Integer p_id ,@Valid @RequestBody Publisher publisherDetails)
    {
        Publisher publisher = publisherService.findById(p_id);
        if (publisher == null)
        {
            return new ResponseEntity<>(emptyPublisher, HttpStatus.NOT_FOUND);
        }
        publisher.setPublisherName(publisherDetails.getPublisherName());
        publisher.setPublisherPhone(publisherDetails.getPublisherPhone());
        publisher.setPublisherAddress(publisherDetails.getPublisherAddress());
        publisherService.save(publisher);
        return  new ResponseEntity<Publisher>(publisher, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/publishers/{p_id}")
    public ResponseEntity<?> deletePublisherById(@PathVariable Integer p_id)
    {
        publisherService.delete(p_id);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/publishers")
    public Iterable<Publisher>  getAllPublishers()
    {
        return publisherService.findAll();
    }

    ///LIBRARY BRANCH///
    ///LIBRARY BRANCH///
    ///LIBRARY BRANCH///
    ///LIBRARY BRANCH///
    @PostMapping("/branches/")
    public @Valid @ResponseBody
    ResponseEntity<?> addLibraryBranch(@RequestBody LibraryBranch libraryBranchDetails)
    {
        LibraryBranch libraryBranch = new LibraryBranch();

        libraryBranch.setBranchName(libraryBranchDetails.getBranchName());
        libraryBranch.setBranchAddress(libraryBranchDetails.getBranchAddress());
        libraryBranchService.save(libraryBranch);
        return new ResponseEntity<LibraryBranch>(libraryBranch, HttpStatus.CREATED);
    }
    @GetMapping("/branches/{b_id}")
    public ResponseEntity<?> getLibraryBranchById(@PathVariable Integer b_id)
    {
        LibraryBranch libraryBranch = libraryBranchService.findById(b_id);

        if (libraryBranch == null)
        {
            return new ResponseEntity<>(emptyLibraryBranch,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<LibraryBranch>(libraryBranch, HttpStatus.OK);
    }
    @PutMapping("/branches/{p_id}")
    public ResponseEntity<?> updateLibraryBranchById( @PathVariable Integer p_id ,@Valid @RequestBody LibraryBranch libraryBranchDetails)
    {
        LibraryBranch libraryBranch = libraryBranchService.findById(p_id);
        if (libraryBranch == null)
        {
            return new ResponseEntity<>(emptyLibraryBranch,HttpStatus.NOT_FOUND);
        }
        libraryBranch.setBranchName(libraryBranchDetails.getBranchName());
        libraryBranch.setBranchAddress(libraryBranchDetails.getBranchAddress());
        return  new ResponseEntity<LibraryBranch>(libraryBranch, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/branches/{b_id}")
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
    @PostMapping("/borrowers/")
    public @Valid @ResponseBody
    ResponseEntity<?> addLibraryBranch(@RequestBody Borrower borrowerDetails)
    {
        Borrower borrower = new Borrower();

        borrower.setName(borrowerDetails.getName());
        borrower.setAddress(borrowerDetails.getAddress());
        borrower.setPhone(borrowerDetails.getPhone());
        borrowerService.save(borrower);
        return new ResponseEntity<Borrower>(borrower, HttpStatus.CREATED);
    }
    @GetMapping("/borrowers/{br_id}")
    public ResponseEntity<?> getBorrowerByCardNo(@PathVariable Integer br_id)
    {
        Borrower borrower = borrowerService.findByCardNo(br_id);
        if (borrower == null)
        {
            return new ResponseEntity<Borrower>(emptyBorrower,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Borrower>(borrower, HttpStatus.OK);
    }
    @PutMapping("/borrowers/{br_id}")
    public ResponseEntity<?> updateBorrowerByCardNo( @PathVariable Integer br_id ,@Valid @RequestBody Borrower borrowerDetails)
    {
        Borrower borrower = borrowerService.findByCardNo(br_id);
        if (borrower == null)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        borrower.setName(borrowerDetails.getName());
        borrower.setAddress(borrowerDetails.getAddress());
        borrower.setPhone(borrowerDetails.getPhone());
        borrowerService.save(borrower);
        return  new ResponseEntity<Borrower>(borrower, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/borrowers/{br_id}")
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
    @PutMapping("/borrower/{br_id}/dueDate")
//    private ResponseEntity<?> updateDueDateById(@PathVariable Integer br_id, @RequestBody Borrower borrower)
//    {
//
//        borrowerService.updateDueDate()
//    }

<<<<<<< HEAD
    ///Book///
=======
>>>>>>> admin
    ///Book///
    ///Book///
    @PostMapping("/books/")
    public @Valid @ResponseBody
    Book addBook(@RequestBody Book bookDetails)
    {
        Book book = new Book();
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setPublisher(bookDetails.getPublisher());
        bookService.save(book);
        return book;
    }
    @GetMapping("/books/{bk_id}")
    public ResponseEntity<?> getBookById(@PathVariable Integer bk_id)
    {
        Book book = bookService.findByBookId(bk_id);
        if (book == null)
        {
            return new ResponseEntity<>(emptyBook,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }
    @PutMapping("/books/{bk_id}")
    public ResponseEntity<?> updateBookById( @PathVariable Integer bk_id ,@Valid @RequestBody Book bookDetails)
    {
        Book book = bookService.findByBookId(bk_id);
        book.setTitle(bookDetails.getTitle());
        bookService.save(book);
        return  new ResponseEntity<Book>(book, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/books/{bk_id}")
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

    ///BOOK LOANS///
    ///BOOK LOANS///
    ///BOOK LOANS///
    @GetMapping("/loans")
    public Iterable<BookLoans> getAllBookLoans() {return bookLoansService.findAll();}
<<<<<<< HEAD
    @PutMapping("/loans/borrowers/{c_n}/books/{bk_id}")
    public ResponseEntity<?> updateDueDate(@PathVariable Integer c_n, @PathVariable Integer bk_id,@RequestBody BookLoans bookLoansDetail)
    {
        if ( bookLoansDetail != null)
        {

            Book book = bookService.findByBookId(bk_id);
            Borrower borrower = borrowerService.findByCardNo(c_n);
            for (BookLoans bookLoans : bookLoansService.findAll())
            {

                if (bookLoans.getId().getCardNo() == borrower.getCardNo() && bookLoans.getId().getBookId() == book.getBookId())
                {
                    bookLoansDetail.setId(bookLoans.getId());
                    bookLoansDetail.setBook(bookLoans.getBook());
                    bookLoansDetail.setBorrower(bookLoans.getBorrower());
=======
    @PutMapping("/loan/borrower/{c_n}/book/{bk_id}")
    public ResponseEntity<?> updateDueDate(@PathVariable Integer c_n, @PathVariable Integer bk_id,@RequestBody BookLoans bookLoansDetail)
    {

        for (BookLoans bookLoans : bookLoansService.findAll())
        {
            if (bookLoans.getCardNo().equals(c_n) && bookLoans.getBookId().equals(bk_id))
            {
                    bookLoansDetail.setBookId(bookLoans.getBookId());
                    bookLoansDetail.setCardNo(bookLoans.getCardNo());
>>>>>>> admin
                    bookLoansDetail.setDateOut(bookLoans.getDateOut());
                    bookLoans.setDueDate(bookLoansDetail.getDueDate());
                    bookLoansService.save(bookLoans);
                    return new ResponseEntity<BookLoans>(bookLoans,HttpStatus.ACCEPTED);
<<<<<<< HEAD
                }
            }
            return new ResponseEntity<>(emptyBookLoans,HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity<>(emptyBookLoans,HttpStatus.BAD_REQUEST);
        }
=======
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
>>>>>>> admin
    }



}
