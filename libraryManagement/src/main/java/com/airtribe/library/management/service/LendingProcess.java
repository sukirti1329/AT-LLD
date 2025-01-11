package com.airtribe.library.management.service;

import com.airtribe.library.management.domain.Book;
import com.airtribe.library.management.domain.User;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class LendingProcess {


    public void issueBook(Book book, User user){
        

    }

    public void returnBook(Book book, User user){

    }

}
