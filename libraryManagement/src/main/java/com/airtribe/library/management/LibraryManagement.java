package com.airtribe.library.management;

import com.airtribe.library.management.domain.Book;
import com.airtribe.library.management.domain.User;
import com.airtribe.library.management.service.BookManagementService;
import com.airtribe.library.management.service.LendingManagementService;
import com.airtribe.library.management.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryManagement {

    @Autowired
    private BookManagementService bookManagementService;

    @Autowired
    private LendingManagementService lendingManagementService;

    @Autowired
    private UserManagementService userManagementService;


    public void permitUserManagementService(User user, Book book){

        userManagementService.registerNewUser(user);
        userManagementService.deRegisterExistingUser(user);
        userManagementService.fetchUserDetails(user);
        userManagementService.checkInBook(user, book);
        userManagementService.checkOutBook(user, book);
    }


    public void permitLendingService(User user, Book book){
        lendingManagementService.issueBook(user, book);
        lendingManagementService.returnBook(user, book);
    }


    public void permitBookManagementService(User user, Book book){
       bookManagementService.removeBook(book);
       bookManagementService.removeBook(book);
       bookManagementService.searchBooksByAnyField(book.getISBN(), book.getTittle(), book.getAuthor());
    }


}
