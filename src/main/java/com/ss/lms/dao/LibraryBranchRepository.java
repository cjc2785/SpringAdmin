package com.ss.lms.dao;

import com.ss.lms.model.LibraryBranch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryBranchRepository extends CrudRepository<LibraryBranch, Integer> {
    LibraryBranch getByBranchId(Integer branchId);
}
