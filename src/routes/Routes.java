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

    public void addBook(Map<String, String> data) {
        Book book = new Book(data);
        library.addBook(book);
    }

    public void removeBookById(String id) {
        library.removeBookById(id);
    }

    // search , update
    public void searchBookById(String id) {
        library.searchBookById(id);
    }

    public void searchBooksByTitle(String title) {
        library.searchBookByTitle(title);
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
}
