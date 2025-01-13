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
}
