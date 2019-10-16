package com.ss.lms.service;

import com.ss.lms.dao.BorrowerRepository;
import com.ss.lms.model.Borrower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowerService {

    @Autowired
    private BorrowerRepository borrowerRepository;

    public Borrower save(Borrower borrower) {
        return borrowerRepository.save(borrower);
    }
    public Iterable<Borrower> findAll() {
        return borrowerRepository.findAll();
    }
    public Borrower findByCardNo(Integer cardNo) {
        return borrowerRepository.getByCardNo(cardNo);
    }

    public void delete(Integer cardNo){
        Borrower borrower = findByCardNo(cardNo);
        borrowerRepository.delete(borrower);
    }
}
