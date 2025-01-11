package com.airtribe.library.management.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Book {

    private String ISBN;
    private String tittle;
    private String author;
    private String publicationYear;
    private Boolean isBookAvailable;


}
