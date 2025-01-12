package com.airtribe.library.management.domain;

import com.airtribe.library.management.enums.UserTypes;
import com.airtribe.library.management.repository.BookRepository;
import com.airtribe.library.management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Librarian {

    private String memberId;
    private String emailId;
    private String phoneNumber;
    private UserTypes userType;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;


    public void registerNewUser(User user){
        userRepository.save(user);

    }

    public void removeExistingUser(User user){
        userRepository.delete(user);
    }

    public void searchBook(Book book){
       // bookRepository.findBy()
   ; }

}
