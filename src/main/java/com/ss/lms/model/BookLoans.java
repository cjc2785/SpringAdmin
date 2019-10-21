package com.ss.lms.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "tbl_book_loans", schema = "library")
public class BookLoans {
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
        this.dueDate = dueDate;
    }
}
