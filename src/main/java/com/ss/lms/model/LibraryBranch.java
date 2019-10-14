package com.ss.lms.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table (name = "tbl_library_branch")
public class LibraryBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer branchId;

    @NotBlank(message = "Branch Name should not be blank")
    private String branchName;

    private String branchAddress;

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }
}
