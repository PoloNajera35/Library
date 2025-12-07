package com.libraryupa.model;

import java.time.LocalDate;

public class Loan {
    private int loanId;
    private int bookId;
    private int memberId;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    public Loan(int loanId, int bookId, int memberId, LocalDate issueDate, LocalDate dueDate) {
        this.loanId = loanId;
        this.bookId = bookId;
        this.memberId = memberId;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
    }


    public int getLoanId() { return loanId; }
    public int getBookId() { return bookId; }
    public int getMemberId() { return memberId; }
    public LocalDate getIssueDate() { return issueDate; }

}