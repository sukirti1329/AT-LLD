package com.airtribe.library.management.domain;


import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Book {

    @Id
    private String ISBN;
    private String tittle;
    private String author;
    private String publicationYear;
    private Boolean isBookAvailable;
    private BookRecord bookRecord;



}
