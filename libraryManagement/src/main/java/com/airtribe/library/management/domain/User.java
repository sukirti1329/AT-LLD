package com.airtribe.library.management.domain;





import com.airtribe.library.management.enums.UserTypes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

private String memberId;
private String emailId;
private String phoneNumber;
private UserTypes userType;

private List<BookRecord> bookRecord;

}