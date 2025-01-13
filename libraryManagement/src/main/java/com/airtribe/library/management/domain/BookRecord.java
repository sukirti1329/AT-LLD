package com.airtribe.library.management.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Entity
public class BookRecord {

    @Id
    private String ISBN;
    private String tittle;
    private String dateOfIssue;
    private String dateOfReturn;
}


