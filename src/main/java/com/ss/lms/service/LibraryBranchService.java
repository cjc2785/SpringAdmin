package com.ss.lms.service;

import com.ss.lms.dao.LibraryBranchRepository;
import com.ss.lms.model.LibraryBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryBranchService {

    @Autowired
    private LibraryBranchRepository libraryBranchRepository;

    public LibraryBranch save(LibraryBranch libraryBranch) {
        return libraryBranchRepository.save(libraryBranch);
    }

    public Iterable<LibraryBranch> findAll() {
        return libraryBranchRepository.findAll();
    }
    public LibraryBranch findById(Integer branchId) {
        return libraryBranchRepository.getByBranchId(branchId);
    }

    public void delete(Integer branchId){
        LibraryBranch libraryBranch = findById(branchId);
        libraryBranchRepository.delete(libraryBranch);
    }
}
