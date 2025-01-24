
/**
 * Admin class is for the Librarian to manage the library system.
 * This can add remove and update books in the library.
 * Basically all the functions couble be done by the Librarian
 * 
 * 
 * choice(String cmd): only recive the command and responce use Routes class to
 * make the changes in Library.
 * 
 * Here will we can add , remove and update the books in the library.
 * As a Admin we can do anything with the databases of the books and we can have
 * multiple books so We can manage the tansactions of the number of books.
 * 
 * 
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

import routes.Routes;
import inventory.Book;

public class Admin {
    Routes routes;
    Scanner scanner;

    public Admin() {
        routes = new Routes();
        scanner = new Scanner(System.in);
    }

    // choice(String cmd): only recive the command and responce
    // use Routes class to make the changes in Library.
    // Here will we can add , remove and update the books in the library.
    public void choice(String... commad) {
        String cmd = commad[0];

        if (cmd.equals("1")) {
            // Add Book
            Map<String, String> data = new HashMap<>();
            System.out.print("Enter book ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter book title: ");
            String title = scanner.nextLine();
            System.out.print("Enter book author: ");
            String author = scanner.nextLine();
            System.out.print("Enter book price: ");
            String price = scanner.nextLine();
            System.out.print("Enter book quantity: ");
            String quantity = scanner.nextLine();
            System.out.print("Enter book publisher: ");
            String publisher = scanner.nextLine();
            System.out.println("Enter book type from the give field :");
            String type = routes.inputFiled();

            data.put("id", id);
            data.put("title", title);
            data.put("author", author);
            data.put("price", price);
            data.put("quantity", quantity);
            data.put("publisher", publisher);
            data.put("type", type);
            routes.addBook(data);
        } else if (cmd.equals("2")) {
            // Remove Book
            System.out.print("Enter book ID to remove: ");
            String bookId = scanner.nextLine();
            routes.removeBookById(bookId);
        } else if (cmd.equals("3")) {
            // Update Book
            Map<String, String> data = new HashMap<>();
            System.out.print("Enter book ID to update: ");
            String given_id = scanner.nextLine();

            // search book by id

            Book book = routes.searchBookById(given_id);
            if (book == null) {
                System.out.println("Book not found.");
                return;
            }
            // if you want to modify the book fields then only enter the value else leave it
            System.out.print("Enter book ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter book title: ");
            String title = scanner.nextLine();
            System.out.print("Enter book author: ");
            String author = scanner.nextLine();
            System.out.print("Enter book price: ");
            String price = scanner.nextLine();
            System.out.print("Enter book quantity: ");
            String quantity = scanner.nextLine();
            System.out.print("Enter book publisher: ");
            String publisher = scanner.nextLine();

            routes.updateBook(given_id, data);
        } else if (cmd.equals("4")) {
            // Search by ID
            System.out.print("Enter book ID to search: ");
            String bookId = scanner.nextLine();
            routes.searchBookById(bookId);
        } else if (cmd.equals("5")) {
            // Search by Title
            System.out.print("Enter book title to search: ");
            String title = scanner.nextLine();
            routes.searchBookByTitle(title);
        } else if (cmd.equals("6")) {
            // Search by Author
            System.out.print("Enter book author to search: ");
            String author = scanner.nextLine();
            routes.searchBooksByAuthor(author);
        }

    }

    public void clear() {
        try {
            // Detect the operating system
            String os = System.getProperty("os.name").toLowerCase();

            // Execute the appropriate command
            if (os.contains("win")) {
                // For Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // For Unix/Linux/Mac
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException ex) {
            System.err.println("Failed to clear the terminal: " + ex.getMessage());
        }
    }

    public void get_user_choice() {
        System.out.println("0. Exit");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Update Book");
        System.out.println("----Search Book----");
        System.out.println("\t4. Search by ID");
        System.out.println("\t5. Search by Title");
        System.out.println("\t6. Search by Author");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
                choice(choice);
                break;
            case "0":
                System.out.println("Exit.........");
                System.exit(0);
                break;
            case "clear":
                clear();
                break;
            default:
                System.out.println("ErrorType : Invalid Choice : ");
                break;
        }
    }

    public static void main(String[] args) {
        Admin admin = new Admin();
        while (true)
            admin.get_user_choice();
    }
}