package com.airtribe.library.management.domain;





import com.airtribe.library.management.enums.UserTypes;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class User {

    @Id
private String memberId;
private String emailId;
private String phoneNumber;
private UserTypes userType;

private List<BookRecord> bookRecord;

}