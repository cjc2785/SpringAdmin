package com.ss.lms.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
<<<<<<< HEAD
import java.sql.Time;
import java.sql.Timestamp;
=======
>>>>>>> admin

@Entity
@Table(name = "tbl_book_loans", schema = "library")
public class BookLoans {
<<<<<<< HEAD
    @EmbeddedId
    private BookLoansId id;
    @ManyToOne
    @JoinColumn(name="bookId")
    @MapsId("bookId")
    private Book book;
    @ManyToOne
    @JoinColumn(name="branchId")
    @MapsId("branchId")
    private LibraryBranch branch;

    @ManyToOne
    @JoinColumn(name="cardNo")
    @MapsId("cardNo")
    private Borrower borrower;
    @Column(name = "dateOut")
    private Timestamp dateOut;
    @Column(name = "dueDate")
    private Timestamp dueDate;

    public BookLoansId getId() {
        return id;
    }

    public void setId(BookLoansId id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LibraryBranch getBranch() {
        return branch;
    }

    public void setBranch(LibraryBranch branch) {
        this.branch = branch;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public Timestamp getDateOut() {
        return dateOut;
    }

    public void setDateOut(Timestamp dateOut) {
        this.dateOut = dateOut;
    }

    public Timestamp getDueDate() {
        return dueDate;
    }

    public void setDueDate(Timestamp dueDate) {
=======
    @Id
    private Integer bookId;
    private Integer branchId;
    private Integer cardNo;
    private String dateOut;
    @Column(name = "dueDate")
    private String dueDate;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public Integer getCardNo() {
        return cardNo;
    }

    public void setCardNo(Integer cardNo) {
        this.cardNo = cardNo;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
>>>>>>> admin
        this.dueDate = dueDate;
    }
}
