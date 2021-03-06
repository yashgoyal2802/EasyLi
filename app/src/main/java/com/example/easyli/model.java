package com.example.easyli;

public class model {
    private String title;
    private String author;
    //private String subtitle;
//  private String publisher;
    private String description;
    private String issuedtill;
    int pages;
    int issue;
    private String isbn;


    public model() {
    }

    public model(String title, String author, String description, String issuedtill, int pages, String isbn,int issue) {
        this.title = title;
        this.author = author;
//        this.subtitle = subtitle;
//        this.publisher = publisher;
        this.description = description;
        this.issuedtill = issuedtill;
        this.pages = pages;
        this.isbn = isbn;
        this.issue=issue;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

//    public String getSubtitle() {
//        return subtitle;
//    }
//
//    public void setSubtitle(String subtitle) {
//        this.subtitle = subtitle;
//    }
//
//    public String getPublisher() {
//        return publisher;
//    }
//
//    public void setPublisher(String publisher) {
//        this.publisher = publisher;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIssuedtill() {
        return issuedtill;
    }

    public void setIssuedtill(String issuedtill) {
        this.issuedtill = issuedtill;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }
}
