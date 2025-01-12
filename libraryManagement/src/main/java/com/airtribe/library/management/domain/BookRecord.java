package com.airtribe.library.management.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookRecord {

    private String ISBN;
    private String tittle;
    private String dateOfIssue;
    private String dateOfReturn;
}
