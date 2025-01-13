package com.airtribe.library.management.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Book {

    @Id
    private String ISBN;

    @Id
    private String tittle;
    private String author;
    private String publicationYear;
    private Boolean isBookAvailable;

    @OneToOne(mappedBy = "book")
    private BookRecord bookRecord;



}
