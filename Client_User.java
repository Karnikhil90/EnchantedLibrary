
import java.io.IOException;
import java.util.Scanner;

import inventory.Book;
import inventory.Library;
// import routes.*;

public class Client_User {

    Scanner scanner;
    Library library;

    public Client_User() {
        scanner = new Scanner(System.in);
        library = new Library();
    }

    // choice(String cmd): only recive the command and responce
    public void choice(String... commad) {
        String cmd = commad[0];
        System.out.println(cmd);
        if (cmd.equals("1")) {
            // Borrow
            System.out.print("Enter book ID to borrow: ");
            String bookId = scanner.nextLine();
            Book book = library.searchBookById(bookId);
            if (book != null) {
                System.out.println("Borrowed: " + book);
                // Add logic to mark the book as borrowed
            } else {
                System.out.println("Book not found.");
            }
        } else if (cmd.equals("2")) {
            // Return
            System.out.print("Enter book ID to return: ");
            String bookId = scanner.nextLine();
            Book book = library.searchBookById(bookId);
            if (book != null) {
                System.out.println("Returned: " + book);
                // Add logic to mark the book as returned
            } else {
                System.out.println("Book not found.");
            }
        } else if (cmd.equals("3")) {
            // Search
            System.out.print("Search by (1) ID or (2) Title: ");
            String searchType = scanner.nextLine();
            if (searchType.equals("1")) {
                System.out.print("Enter book ID: ");
                String bookId = scanner.nextLine();
                Book book = library.searchBookById(bookId);
                if (book != null) {
                    System.out.println("Found: " + book);
                } else {
                    System.out.println("Book not found.");
                }
            } else if (searchType.equals("2")) {
                System.out.print("Enter book title: ");
                String title = scanner.nextLine();
                Book book = library.searchBookByTitle(title);
                if (book != null) {
                    System.out.println("Found: " + book);
                } else {
                    System.out.println("Book not found.");
                }
            } else {
                System.out.println("Invalid search type.");
            }
        } else {
            System.out.println("Invalid command.");
        }
    }

    private void clear() {
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
        String choice;
        System.out.println("choose your choice =>");
        System.out.print("1. Borrow \n2. Return \n3. Search\n");
        System.out.print("Enter your choice : ");

        choice = scanner.nextLine();

        switch (choice) {
            case "1":
            case "2":
            case "3":
                choice(choice);
                break;
            case "0":
                System.out.println("Exit");
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
        Client_User client = new Client_User();
        while (true)
            client.get_user_choice();
    }
}