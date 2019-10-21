package com.ss.lms.service;

import com.ss.lms.dao.BookLoansRepository;
<<<<<<< HEAD
import com.ss.lms.model.Book;
import com.ss.lms.model.BookLoans;
import com.ss.lms.model.Borrower;
=======
import com.ss.lms.model.BookLoans;
>>>>>>> admin
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookLoansService {
    @Autowired
    private BookLoansRepository bookLoansRepository;

    public BookLoans save(BookLoans bookLoans) {
        return bookLoansRepository.save(bookLoans);}
<<<<<<< HEAD
    public Optional<BookLoans> findByBoth(Borrower borrower, Book book)
    {

        return bookLoansRepository.getByBorrowerAndBook(borrower,book);
=======
    public Optional<BookLoans> findByBoth( Integer cardNo,Integer bookId)
    {
        return bookLoansRepository.getByCardNoAndBookId(cardNo,bookId);
>>>>>>> admin
    }

    public Iterable<BookLoans> findAll()
    {
        return bookLoansRepository.findAll();
    }
}
