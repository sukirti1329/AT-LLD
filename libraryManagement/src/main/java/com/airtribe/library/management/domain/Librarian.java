package com.airtribe.library.management.domain;

import org.springframework.beans.factory.annotation.Autowired;

public class Librarian {

    @Autowired
    private User user;


    public void registerNewUser(User user){
        //UserRepository.saveNewUser
    }

    public void searchBook(Book book){

    }

}
