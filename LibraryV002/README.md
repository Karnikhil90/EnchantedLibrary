# Project Structure

## Management Folder

### Main Class (`UserControl.java`)

- `Choice()`: Display user menu and handle choices.
- `AddingNewBook()`: Handle the process of adding a new book.
- `readAndDisplay(FileName)`: Read a file (.txt) and display its contents.

### LibraryManagementSystem Class (`LibraryManagementSystem.java`)

- `SearchByID()`: Search for a book by ID.
- `DisplayAllBook()`: Display all books in the library.
- `DisplayBook()`: Display a specific book.
- `SearchBookByName()`: Search for a book by name.
- `AddbookByUser()`: Add a new book.
- `BOOKID_Gernrator()`: Generate a new Book ID.

## BookData Folder

### Library Class (`Library.java`)

- `getBooks(indexOfBook)`: Return a list of all books or a specific book based on the index.
- `addBook(bookName,bookPrice, field)`: Add a book to the library.
- `searchBookById(bookId)`: Search for a book by ID.
- `GetBookID()`, `GetBookID(index)`, `GetBook(index)`, `GetBook()`, `GetBookPrice(index)`, `GetBookWriter()`, `GetBookWriter(index)`, `GetFields()`: Get book information.
- `AddBookData(NewBookName, NewBookWriter, NewBookPrice, NewBookID)`: Add new book data.

### FileAccess Class (`FileAccess.java`)

- `readData()`: Read book data from files.
- `writeData()`: Write book data to files.

## TxtData Folder

- Contains details about the version and o.

## Contact Information

- **Twitter:** [@karnikhil90](https://twitter.com/karnikhil90)
- **Email:** [nikhilkarmakar4020@gmail.com](mailto:nikhilkarmakar4020@gmail.com)
