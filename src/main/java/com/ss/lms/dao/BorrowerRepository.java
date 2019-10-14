package com.ss.lms.dao;

import com.ss.lms.model.Borrower;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowerRepository extends CrudRepository<Borrower, Integer> {
    Borrower getByCardNo(Integer cardNo);
}
