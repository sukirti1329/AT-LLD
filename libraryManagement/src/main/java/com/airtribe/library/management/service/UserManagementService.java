package com.airtribe.library.management.service;

import com.airtribe.library.management.domain.Book;
import com.airtribe.library.management.domain.BookRecord;
import com.airtribe.library.management.domain.User;
import com.airtribe.library.management.repository.BookRepository;
import com.airtribe.library.management.repository.UserRepository;
import com.airtribe.library.management.util.DateUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Slf4j
public class UserManagementService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LendingManagementService lendingManagementService;

    @Autowired
    private BookManagementService bookManagementService;

    public User registerNewUser(User user){
        return userRepository.save(user);
    }

    public void deRegisterExistingUser(User user){
        userRepository.delete(user);
    }

    public User fetchUserDetails(User user){
            if(userRepository.findById(user.getMemberId()).isPresent()) {
                return userRepository.findById(user.getMemberId()).get();
            }
            log.error("Requested user doesn't exist");
            return null;
    }

    public void checkOutBook(User user, Book book){
        lendingManagementService.issueBook(user, book);

    }

    public void checkInBook(User user, Book book){
        lendingManagementService.returnBook(user, book);
    }


    public List<BookRecord> fetchDetailsOfBorrowedBooks(User user){
       Optional<User> userDetails =  userRepository.findById(user.getMemberId());
        return userDetails.map(User::getBookRecord).orElse(null);
    }

    public void updateBookRecordDetailsOnReturn(User user, Book book){
        Optional<User> userDetails = userRepository.findById(user.getMemberId());
        userDetails.flatMap(value -> value.getBookRecord().stream().filter(bookRecord -> bookRecord.getISBN().equals(book.getISBN()))
                .findFirst()).ifPresent(bookRecord -> bookRecord.setDateOfReturn(DateUtility.convertCurrentDateToString()));
    }

    public Book searchBook(String title, String author, String isbn){
        return bookManagementService.searchBooksByAnyField(isbn, title, author);
    }
}
