package com.ss.lms.dao;

import com.ss.lms.model.BookLoans;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookLoansRepository extends CrudRepository<BookLoans, Integer> {

    Optional<BookLoans> getByCardNoAndBookId( Integer cardNo,Integer bookId);

}
