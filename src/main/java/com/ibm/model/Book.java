package com.ibm.model;

import java.io.Serializable;

public class Book implements Serializable {

    String isbn;
    String title;
    String author;
    String publisher;
    String dateOfPublishing;
    String edition;
    String category;
    String language;

    public Book() {
    }

    public Book(String isbn, String title, String author, String publisher, String dateOfPublishing, String edition, String category, String language) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.dateOfPublishing = dateOfPublishing;
        this.edition = edition;
        this.category = category;
        this.language = language;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDateOfPublishing() {
        return dateOfPublishing;
    }

    public void setDateOfPublishing(String dateOfPublishing) {
        this.dateOfPublishing = dateOfPublishing;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", dateOfPublishing='" + dateOfPublishing + '\'' +
                ", edition='" + edition + '\'' +
                ", category='" + category + '\'' +
                ", language='" + language + '\'' +
                '}';
    }

    public Book updateBook(Book newBook) {
        Book updatedBook = new Book();
        updatedBook.isbn = newBook.isbn;
        updatedBook.title = newBook.title;
        updatedBook.author = newBook.author;
        updatedBook.publisher = newBook.publisher;
        updatedBook.dateOfPublishing = newBook.dateOfPublishing;
        updatedBook.edition = newBook.edition;
        updatedBook.category = newBook.category;
        updatedBook.language = newBook.language;

        return updatedBook;
    }
}
