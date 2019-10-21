package com.ss.lms.service;

import com.ss.lms.dao.BookLoansRepository;
import com.ss.lms.model.Book;
import com.ss.lms.model.BookLoans;
import com.ss.lms.model.Borrower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookLoansService {
    @Autowired
    private BookLoansRepository bookLoansRepository;

    public BookLoans save(BookLoans bookLoans) {
        return bookLoansRepository.save(bookLoans);}
    public Optional<BookLoans> findByBoth(Borrower borrower, Book book)
    {

        return bookLoansRepository.getByBorrowerAndBook(borrower,book);
    }

    public Iterable<BookLoans> findAll()
    {
        return bookLoansRepository.findAll();
    }
}
