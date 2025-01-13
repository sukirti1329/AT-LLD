package com.airtribe.library.management.service;

import com.airtribe.library.management.domain.Book;
import com.airtribe.library.management.domain.BookRecord;
import com.airtribe.library.management.domain.User;
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


    public void issueBook(User user, Book book) {

        /*Check if book is available  in Library*/
        Book bookDetails = bookManagementService.searchBooks(book.getISBN(), book.getTittle(), book.getAuthor());
        if (null != bookDetails && bookDetails.getIsBookAvailable()) {
            /*Check if user exist, if not register user */
            User userDetails = userManagementService.fetchUserDetails(user);
            if (null == userDetails) {
                userDetails = userManagementService.registerNewUser(user);
            }

            //Update is available flag and BookRecordDetails
            List<BookRecord> userBookRecordDetails = userDetails.getBookRecord();
            //Update user's book record details
            BookRecord userUpdatedBookRecord = bookManagementService.updateBookRecordForIssue(book);
            userBookRecordDetails.add(userUpdatedBookRecord);
        } else {
            log.error("Sorry requested book is not available");
        }
    }

    /// /Update isAvailableFlag & Return Date for a bookRecord
    /// Update user's bookRecordDetails
    public void returnBook(User user, Book book) {
        bookManagementService.updateBookDetailsOnReturn(book);
        userManagementService.updateUserBookRecordDetailsOnReturn(user, book);
    }


}
