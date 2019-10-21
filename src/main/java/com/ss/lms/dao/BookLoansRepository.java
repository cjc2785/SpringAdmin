package com.ss.lms.dao;

import com.ss.lms.model.Book;
import com.ss.lms.model.BookLoans;
import com.ss.lms.model.Borrower;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public interface BookLoansRepository extends CrudRepository<BookLoans, Map<Book , Borrower>> {

    Optional<BookLoans> getByBorrowerAndBook(Borrower borrower, Book Book);


}
