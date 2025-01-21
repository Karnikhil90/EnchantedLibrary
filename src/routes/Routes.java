package routes;

/**
 * Routes class will provide the routes for the application
 * Then It can be used by the Classes like Admin, Client_User
 * So, There will be single class who can make the changes in Library.
 *
 * 
 */
import java.util.*;

import inventory.Book;
import inventory.Library;
import FileAccess.MyCSV;

public class Routes {
    private Library library;
    private Scanner scanner;
    private String filepath = ".\\database\\books.csv";
    private Book book;

    public Routes() {
        this.library = new Library(filepath);
    }

    public Routes(String filepath) {
        this.library = new Library(filepath);
    }

    public void addBook(Map<String, String> data) {
        Book book = new Book(data);
        library.addBook(book);
    }

    public void removeBookById(String id) {
        library.removeBookById(id);
    }

    // search , update
    public Book searchBookById(String id) {
        return library.searchBookById(id);
    }

    public Book searchBookByTitle(String title) {
        return library.searchBookByTitle(title);
    }

    public List<Book> searchBooksByAuthor(String author) {
        ArrayList<Book> books = library.getBooks();
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book);
            }
        }
        return result;
    }

    // public void searchBooksByAuthor(String author) {
    // List<Book> books = searchBooksByAuthor(author);

    // if (books.size() == 0) {
    // System.out.println("No books found.");
    // } else {
    // for (Book book : books) {
    // System.out.println(book.toString());
    // }
    // }
    // }

    public void updateBook(String id, Map<String, String> data) {
        library.updateBookById(id, new Book(data));
    }

    public void borrowBook(String id, String borrowerName) {
        Book book = searchBookById(id);
        if (book != null) {
            if (book.getQuantity() > 0) {
                book.decrementQuantity(1);
                updateBook(id, book.toMap());
                System.out.println(borrowerName + " has borrowed the book: " + book.getTitle());

                // TODO: Track borrowed book details, including borrowerName and borrowed date
            } else {
                System.out.println("The book is out of stock.");
            }
        } else {
            System.out.println("Book not found.");
        }
    }

    public void returnBook(String id, String borrowerName) {
        Book book = searchBookById(id);
        if (book != null) {
            book.incrementQuantity(1);
            updateBook(id, book.toMap());
            System.out.println(borrowerName + " has returned the book: " + book.getTitle());

            // TODO: Remove or update the tracking details for this borrower
        } else {
            System.out.println("Book not found.");
        }
    }

    // TODO: Create a system to track borrowed books, the borrowers, and the dates.
    // Example: Use a Map<String, List<String>> where the key is the book ID,
    // and the value is a list containing borrower details and the borrow date.

}
