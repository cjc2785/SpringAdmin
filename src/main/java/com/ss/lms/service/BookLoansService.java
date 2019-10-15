package com.ss.lms.service;

import com.ss.lms.dao.BookLoansRepository;
import com.ss.lms.model.BookLoans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookLoansService {
    @Autowired
    private BookLoansRepository bookLoansRepository;

    public BookLoans save(BookLoans bookLoans) {
        return bookLoansRepository.save(bookLoans);}
    public Optional<BookLoans> findByBoth( Integer cardNo,Integer bookId)
    {
        return bookLoansRepository.getByCardNoAndBookId(cardNo,bookId);
    }

    public Iterable<BookLoans> findAll()
    {
        return bookLoansRepository.findAll();
    }
}
