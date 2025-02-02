package inventory;

import java.util.*;

// import FileAccess.FileAccess;
import FileAccess.MyCSV;

public class Library {
    private ArrayList<Book> books;
    private MyCSV file;
    private String filepath = ".\\database\\books.csv"; // default file path

    public Library() {
        books = new ArrayList<>();
        file = new MyCSV(filepath);
        // loadBooks();
    }

    public Library(String filepath) {
        books = new ArrayList<>();
        file = new MyCSV(filepath);
        // loadBooks();
    }

    public ArrayList<Book> getBooks() {
        return new ArrayList<>(books);
    }

    // loadBooks(): load books from the file
    public void loadBooks() {
        List<Map<String, String>> data = file.toMap();
        for (Map<String, String> row : data) {
            Book book = new Book(row);
            books.add(book);
        }
    }

    // Add a book to the library
    public void addBook(Book book) {
        books.add(book);
        // save(book.toString(), true);
    }

    public void addBook(Map<String, String> data) {
        Book book = new Book(data);
        books.add(book);
        // save(book.toString(), true);
    }

    public void addBooks(List<Book> books) {
        this.books.addAll(books);
        // save(false);
    }

    // Remove a book from the library by ID
    public boolean removeBookById(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                books.remove(book);
                return true;
            }
        }
        return false;
    }

    // Remove a book from the library by title
    public boolean removeBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                books.remove(book);
                return true;
            }
        }
        return false;
    }

    // Update a book's information by ID
    public boolean updateBookById(String id, Book newBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.set(i, newBook);
                return true;
            }
        }
        return false;
    }

    // Update a book's information by title
    public boolean updateBookByTitle(String title, Book newBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                books.set(i, newBook);
                return true;
            }
        }
        return false;
    }

    // Search for a book by ID
    public Book searchBookById(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    // Search for a book by title
    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void save() {
        file.writeAll();

    }

    // public void save(boolean append) {
    // file.save(filepath, append);
    // }

    // public void save(String filepath, boolean append) {
    // file.save(filepath, append);
    // }
}