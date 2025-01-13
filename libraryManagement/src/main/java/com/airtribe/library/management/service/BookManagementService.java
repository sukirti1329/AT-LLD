package com.airtribe.library.management.service;

import com.airtribe.library.management.domain.Book;
import com.airtribe.library.management.domain.BookRecord;
import com.airtribe.library.management.repository.BookRepository;
import com.airtribe.library.management.util.DateUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class BookManagementService {

    @Autowired
    private BookRepository bookRepository;

    public Book searchBooksByAnyField(String isbn, String title, String author) {
        return bookRepository.findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCaseOrIsbn(title, author, isbn);
    }

    public Book searchBooks(String title, String author, String isbn) {

        if (title != null && !title.isEmpty()) {
            return bookRepository.findByTitleContainingIgnoreCase(title);
        } else if (author != null && !author.isEmpty()) {
            return bookRepository.findByAuthorContainingIgnoreCase(author);
        } else if (isbn != null && !isbn.isEmpty()) {
            return bookRepository.findByIsbn(isbn);
        } else {
            log.error("No matching book record found");
            return null;

        }
    }


    public BookRecord updateBookRecordForIssue(Book book) {
        book.setIsBookAvailable(false);
        BookRecord existingBookRecord = book.getBookRecord();
        existingBookRecord.setDateOfIssue(DateUtility.convertCurrentDateToString());
        return existingBookRecord;
    }

    public void updateBookDetailsOnReturn(Book book) {
        book.setIsBookAvailable(true);
        BookRecord existingBookRecord = book.getBookRecord();
        existingBookRecord.setDateOfReturn(DateUtility.convertCurrentDateToString());
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void removeBook(Book book) {
        bookRepository.delete(book);
    }

    public long findTotalCountOfBooks() {
        return bookRepository.findAll().size();
    }


}
