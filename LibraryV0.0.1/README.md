# Project Structure

## Main Class (`Main.java`)

- `main()*`: Entry point for the program.
- `getUserChoice()*`: Takes user input for desired operations.
- `performUserOperation(int choice, LibraryManagement libraryManagement)*`: Calls methods from `LibraryManagement` based on user choices.

## LibraryManagement Class (`LibraryManagement.java`)

- `addBook(Book book, Library library)*`: Adds a new book to the library.
- `searchBook(String bookId, Library library)*`: Searches for a book in the library.

## Library Class (`Library.java`)

- `getBooks(int indexOfBook)*`: Returns a list of all books in the library or a specific book based on the index.
- `addBook(String BookName, BookPrice, int Field)*`: Adds a book to the library with specified details.
- `searchBookById(String bookId)*`: Searches for a book by ID.

## Contact Information

- **Twitter:** [@karnikhil90](https://twitter.com/karnikhil90)
- **Email:** [nikhilkarmakar4020@gmail.com](mailto:nikhilkarmakar4020@gmail.com)
