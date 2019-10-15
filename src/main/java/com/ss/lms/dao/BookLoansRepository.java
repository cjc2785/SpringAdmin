package com.ss.lms.dao;

import com.ss.lms.model.BookLoans;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookLoansRepository extends CrudRepository<BookLoans, Integer> {

//    @Query("SELECT t FROM tbl_book_loans t WHERE bookId = ?1 AND cardNo = ?2")
//    BookLoans getByBookIdAndCardNo( Integer bookId, Integer cardNo);

}
