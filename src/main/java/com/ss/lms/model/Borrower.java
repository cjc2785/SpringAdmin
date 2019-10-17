package com.ss.lms.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_borrower", schema = "library")
public class Borrower {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @NotNull
    private Integer cardNo;
    @NotBlank (message = "Borrower Name Cannot Be Blank")
    private String name;
    private String address;
    private String phone;

    public Integer getCardNo() {
        return cardNo;
    }

    public void setCardNo(Integer cardNo) {
        this.cardNo = cardNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
