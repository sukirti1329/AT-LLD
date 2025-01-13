
**Library Management Service**

A Spring Boot-based Library Management Service designed to manage users, books, and lending operations. The service is built following SOLID principles, with a focus on simplicity, readability, and easy integration with cloud environments.

Table of Contents
**Description
Entities
Services
User Management Service
Book Management Service
Lending Service
Design Patterns
Installation
Usage
Contributing
License
Description**
This project provides a Library Management System that allows for managing users, books, and lending operations. It supports:

User Management: Registering, de-registering, and managing book transactions.
Book Management: Maintaining an inventory of books, adding/removing books, and searching.
Lending Service: Handling the core library operations like issuing and returning books.
The service is built with Spring Boot, utilizes JPA for database access, and follows industry-standard patterns to ensure clean, modular, and maintainable code.

Entities
1. User
   Represents a library user who can borrow and return books.

Key Attributes:
id: Unique user identifier.
name: Full name of the user.
email: User's email address.
borrowedBooks: List of books borrowed by the user.
2. Librarian
   Represents a librarian who manages the library's books and users.

Key Attributes:
id: Unique librarian identifier.
name: Full name of the librarian.
email: Librarian's email address.
role: Typically "Librarian".
3. Book
   Represents a book in the library system.

Key Attributes:
id: Unique book identifier.
title: Title of the book.
author: Author(s) of the book.
isbn: ISBN number of the book.
availability: Number of copies available.
4. BookRecord
   Tracks the borrowing and returning activities of books.

Key Attributes:
id: Unique record identifier.
userId: ID of the user who borrowed the book.
bookId: ID of the borrowed book.
borrowedDate: Date when the book was borrowed.
dueDate: Due date for the book to be returned.
returnedDate: Date when the book was returned.
Services
1. User Management Service
   Handles all user-related operations such as registration, deregistration, borrowing, returning, and searching for books.

Key Features:
Register User: Allows users to register with the library.
DeRegister User: Deletes a user from the system.
CheckIn and CheckOut Book: Users can borrow (check out) and return (check in) books.
Get Borrowed Books: Fetches a list of all books currently borrowed by the user.
Search Books: Allows users to search for books by title, author, or ISBN.
2. Book Management Service
   Manages the library's inventory of books, allowing for searching, adding, and removing books.

Key Features:
Add Book: Adds a new book to the library inventory.
Remove Book: Deletes a book from the library's collection.
Search Books: Allows librarians to search for books by title, author, or ISBN.
3. Lending Service
   Handles the core business logic of issuing and returning books.

Key Features:
Issue Book: Processes the borrowing of a book by a user.
Return Book: Handles the returning of a borrowed book.
Design Patterns
This project uses the following design patterns to ensure clean code and maintainability:

1. Singleton
   The Singleton pattern is used for logging to ensure there is only one instance of the logger throughout the application.

2. Builder Pattern (Lombok)
   The Lombok Builder pattern is used to simplify object creation and ensure immutability for entities such as Book and User.

3. SOLID Principles
   Single Responsibility Principle (SRP): Each service has one responsibility (e.g., UserManagementService, BookManagementService, and LendingService).
   Open/Closed Principle: Services are open for extension but closed for modification. New features can be added by extending existing services without modifying the existing code.
   Dependency Injection: Dependencies are injected based on the required functionality, keeping the system flexible and modular