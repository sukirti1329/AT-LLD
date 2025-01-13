<

+------------------------------------------+
|               <<abstract>>              |
|                  User                    |
|------------------------------------------|
| - memberId: String                       |
| - name: String                           |
| - email: String                          |
| - userType: UserType                     |
|------------------------------------------|
| + registerUser()                         |
| + deRegisterUser()                       |
| + checkInBook()                          |
| + checkOutBook()                         |
| + getBorrowedBooks()                     |
| + searchBooks()                          |
+------------------------------------------+
/  \
/    \
/      \
+----------------+   +----------------+
|   Librarian    |   |     Member     |
|----------------|   |----------------|
| - role: String  |   | - borrowedBooks: List<BookRecord> |
+----------------+   +----------------+
|
|
v
+------------------------------------------+
|                 Book                     |
|------------------------------------------|
| - isbn: String                           |
| - title: String                          |
| - author: String                         |
| - isAvailable: boolean                   |
+------------------------------------------+
|
v
+------------------------------------------+
|               BookRecord                 |
|------------------------------------------|
| - isbn: String                           |
| - borrowedDate: Date                     |
| - returnedDate: Date                     |
+------------------------------------------+
^
|
+-----------------------------+
|   UserManagementService      |
|-----------------------------|
| + registerUser()             |
| + deRegisterUser()           |
| + checkInBook()              |
| + checkOutBook()             |
| + getBorrowedBooks()         |
| + searchBooks()              |
+-----------------------------+
^
|
+-----------------------------+
|    BookManagementService     |
|-----------------------------|
| + addBook()                  |
| + removeBook()               |
| + searchBooks()              |
+-----------------------------+
^
|
+-----------------------------+
|        LendingService        |
|-----------------------------|
| + issueBook()                |
| + returnBook()               |
+-----------------------------+
>
