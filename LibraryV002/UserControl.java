package LibraryV002;

import java.util.Scanner;
import LibraryV002.BookData.*;
import LibraryV002.Management.LibraryManagementSystem;

/*
* This class represents user control for the Library Management System.
*/
public class UserControl extends LibraryManagementSystem {

    Scanner input; // Scanner object for user input
    Library MainLibrary; // Library
    FileAccess GetFiles; //

    // * File path of the version file
    private final String filePathOfVersionData = "LibraryV002\\TextInfo\\v0.0.2.txt";
    // * File path of the just one's when it starts
    private static final String filePathOfStarterData = "LibraryV002\\TextInfo\\stater.txt";
    String[] RecivedField;

    /*
     * Constructor for UserControl class
     */
    UserControl() {
        super();
        input = new Scanner(System.in); // Initialize Scanner for user input
        MainLibrary = new Library();
        GetFiles = new FileAccess();
        RecivedField = MainLibrary.GetFields();
    }

    /*
     * Method to get user input as a string
     * 
     * @return User input as a string
     */
    private String UserInput() {
        System.out.print("$_:"); // Prompt for user input
        String choice = input.nextLine(); // Read user input
        return choice;
    }

    /*
     * Method to display user menu and handle user choices
     * Few Extra:
     * -> "version" : for knowning the current version
     * -> "exit" : for Close the program
     */

    private void Choice() {
        // Displaying menu options
        System.out.println("\tEnter a valid Choice :");
        System.out.println("\t1. Add Books to Library ");
        System.out.println("\t2. Display All Books  ");
        System.out.println("\t3. Display Book On a Secific Field");
        System.out.println("\t4. Search Books By Name ");
        System.out.println("\t5. Search Books By ID ");

        String choice = UserInput(); // Get user choice
        // Handling user choices
        if (!(choice.equalsIgnoreCase("exit") ||
                (choice.equalsIgnoreCase("e")))) {
            if (choice.equalsIgnoreCase("1")) {
                AddingNewBook();
            } else if (choice.equalsIgnoreCase("2")) {
                // Display all the books
                DisplayAllBook();
            } else if (choice.equalsIgnoreCase("r") ||
                    choice.equalsIgnoreCase("refresh")) {
                MainLibrary.RefeshData();
            } else if (choice.equalsIgnoreCase("3")) {

                System.out.println("\n\t***Select the field of the Book***");
                System.out.println("\t\t0. OTHERS ");
                // TODO : @return Ask for Field of the Book
                for (int i = 0; i < RecivedField.length; i++) {
                    if (CountBookInOneField(String.valueOf(i + 1)) > 0)
                        System.out.println("\t\t" + (i + 1) + ". " + toTitle(RecivedField[i]));
                }
                System.out.print("\tEnter the choice :");
                String SpecificField = input.nextLine();
                if (!(SpecificField.trim().equalsIgnoreCase("e") || SpecificField.trim().equalsIgnoreCase("exit")))
                    FielterToDisplayBook(SpecificField.trim());

            } else if (choice.equalsIgnoreCase("4")) {
                // Handling search choices
                System.out.print("Tell me what ever you remember about the book name \n");
                SearchBookByName(UserInput());

            } else if (choice.equalsIgnoreCase("5")) {
                try {
                    SearchByID(UserInput());
                } catch (Exception e) {
                    System.err.println("\n****OUT OF INDEX****");
                }
            }

            else if (choice.equalsIgnoreCase("version") || choice.equalsIgnoreCase("v")) {
                // Display system version
                readAndDisplay(filePathOfVersionData);
            } else {
                System.out.println("\t\t*****Please Give a valid Input*****");
            }

            System.out.println("\n\n=============================================================\n");
            Choice(); // Recursive call to keep the program running
            System.out.println("***System Exited***** ");
        }
    }

    public void AddingNewBook() {

        System.out.print("Name Of the Book :");
        String name = input.nextLine();
        System.out.print("Who is the author of the Book :");
        String author = input.nextLine();
        System.out.print("What is the price of the book :");
        String price = input.nextLine();

        System.out.println("\n\t***Select the field of the Book***");
        System.out.println("0. OTHERS ");
        // TODO : Ask for Field of the Book
        for (int i = 0; i < RecivedField.length; i++) {
            System.out.println((i + 1) + ". " + toTitle(RecivedField[i]));
        }
        System.out.print("Enter the choice :");
        String choice = input.nextLine();
        System.out.println("\n\n\n");
        boolean passOrNot = true;
        try {
            choice = choice.trim();
            if (!(choice.equals(""))) {
                passOrNot = (Integer.valueOf(choice) >= 0 && Integer.valueOf(choice) <= RecivedField.length) ? true
                        : false;
                if (passOrNot)
                    AddbookByUser(name, author, price, choice);
                else if (Integer.valueOf(choice) >= RecivedField.length)
                    System.out.println("****ErrorType: Out of index input****");
            } else {
                System.out.println("***ErrorType: Give some Input please ***");
            }
        } catch (Exception e) {
            System.err.println("***ErrorType: " + e.getMessage() + "****");
        }
    }

    /*
     * Method to Read A file (.txt) and display the file contents
     */
    private void readAndDisplay(String FileName) {

        String[] recived = GetFiles.readAndDisplayFileInfo(FileName);
        for (int i = 0; i < recived.length; i++) {
            if (recived[i] != null) // Just For test
                System.out.println(recived[i]);
        }
    }

    /*
     * Main method to start the program
     */
    public static void main(String[] args) {
        UserControl myObj = new UserControl();
        myObj.readAndDisplay(filePathOfStarterData);
        myObj.Choice(); // Creating an instance and calling the Choice method
    }
}