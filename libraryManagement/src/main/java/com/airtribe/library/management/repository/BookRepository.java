package com.airtribe.library.management.repository;

import com.airtribe.library.management.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, String> {

    Book findByTitleContainingIgnoreCase(String title);

    // Search books by author
    Book findByAuthorContainingIgnoreCase(String author);

    // Search books by ISBN
    Book findByIsbn(String isbn);

    // You can also create more flexible queries by combining multiple search criteria:
    Book findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCaseOrIsbn(String title, String author, String isbn);

}
