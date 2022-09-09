package com.ibm.service;


import com.ibm.model.Book;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class LibraryService {
        static List<Book>  bookList = null;
        static {
            bookList = new ArrayList<Book>();
            Book book1 = new Book("1111-11-11", "AWS Serverless", "Jay", "Penguin", "12/10/2020", "1st Edition","Fiction", "English");
            Book book2 = new Book("2222-22-22", "AWS Lambda", "John", "Penguin", "12/10/2020", "2nd Edition","Stories", "French");
            Book book3 = new Book("3333-33-33", "AWS Kinesis", "Wick", "Penguin", "12/10/2020", "3rd Edition","Comics", "French");
            Book book4 = new Book("4444-44-44", "AWS Elasticsearch", "Bill", "Penguin", "12/10/2020", "4th Edition","Fiction", "English");
            Book book5 = new Book("5555-55-55", "AWS Kibana", "John", "Penguin", "12/10/2020", "5th Edition","Stories", "German");

            bookList.add(book1);
            bookList.add(book2);
            bookList.add(book3);
            bookList.add(book4);
            bookList.add(book5);

        }



    public List<Book> getAllBooks() {

        return LibraryService.bookList;
    }
        public List<Book> getFilteredBooks(String category, String language) {

            List<Book> filteredBooks = LibraryService.bookList
                    .stream()
                    .filter(book -> book.getCategory().equalsIgnoreCase(category) && book.getLanguage().equalsIgnoreCase(language))
                    .collect(Collectors.toList());
            return filteredBooks;
    }

    public Book getBookByIsbn(String isbn) {
            Book myBook = null;
            for(Book book: LibraryService.bookList) {
                if(book.getIsbn().equalsIgnoreCase(isbn)) {
                    myBook = book;
                    break;
                }
            }
            return myBook;
    }

    public List<Book> getBookByAuthor(String author) {

        List<Book> booksOfSameAuthor = LibraryService.bookList
                .stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
        return booksOfSameAuthor;
    }

    public void addBook(Book book) {
        LibraryService.bookList.add(book);
    }

    public void updateBook(Book book) {
        List<Book> updatedList = LibraryService.bookList.stream()
                .map(listbook -> listbook.getIsbn().equalsIgnoreCase(book.getIsbn()) ?
                        listbook.updateBook(book): listbook)
                .collect(Collectors.toList());
        LibraryService.bookList = updatedList;
    }

    public void deleteBook(String isbn) {
        for(Book book: LibraryService.bookList) {
            if(book.getIsbn().equalsIgnoreCase(isbn)) {
                LibraryService.bookList.remove(book);
                break;
            }
        }
    }
}
