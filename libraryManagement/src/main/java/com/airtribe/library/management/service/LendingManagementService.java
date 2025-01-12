package com.airtribe.library.management.service;

import com.airtribe.library.management.domain.Book;
import com.airtribe.library.management.domain.BookRecord;
import com.airtribe.library.management.domain.User;
import com.airtribe.library.management.repository.BookRepository;
import com.airtribe.library.management.repository.UserRepository;
import com.airtribe.library.management.util.DateUtility;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Slf4j
public class LendingManagementService {

    @Autowired
    private BookManagementService bookManagementService;

    @Autowired
    private UserManagementService userManagementService;


    public void issueBook(User user, Book book){

        /*Check if book is available */
        Book bookDetails = bookManagementService.searchBooks(book.getISBN(), book.getTittle(), book.getAuthor());
        if(null!=bookDetails){
            /*Check if user exist, if not register user */
            User userDetails = userManagementService.fetchUserDetails( user);
            if(null == userDetails){
               userDetails =  userManagementService.registerNewUser(user);
            }
            //Update the BookRecordDetails
            List<BookRecord> bookRecordDetails = userDetails.getBookRecord();
            BookRecord updatedBookRecord = bookManagementService.updateBookRecordForIssue(book);
            bookRecordDetails.add(updatedBookRecord);

            //TODO: Code to be checked
            bookManagementService.removeBook(book);
        }else{
            log.error("Sorry requested book is not available");
        }
    }

    ////Updates Return Date record for a book
    /// Update return date record for a book for a user
    /// Add the returned book to the book inventory
    public void returnBook(User user, Book book){
        bookManagementService.updateBookRecordOnReturn(book);
        userManagementService.updateBookRecordDetailsOnReturn(user, book);
        //TODO: Code to be checked
        bookManagementService.addBook(book);
    }


}
