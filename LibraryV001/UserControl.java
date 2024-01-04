package LibraryV001;

import java.io.File;
import java.util.Scanner;

/*
 * This class represents user control for the Library Management System.
 */
public class UserControl extends LibraryManagementSystem {

    Scanner input; // Scanner object for user input

    /*
     * Constructor for UserControl class
     */
    UserControl() {
        input = new Scanner(System.in); // Initialize Scanner for user input
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
     */
    private void Choice() {
        // Displaying menu options
        System.out.println("\tEnter a valid Choice :");
        System.out.println("\t1. Add Books to Library ");
        System.out.println("\t2. Display Books ");
        System.out.println("\t3. Search Books ");

        String choice = UserInput(); // Get user choice

        // Handling user choices
        if (!(choice.equalsIgnoreCase("exit"))) {
            if (choice.equalsIgnoreCase("1")) {
                System.out.println("\t****This Service is Under Working****");
            } else if (choice.equalsIgnoreCase("2")) {
                // Display all the books
                DisplayAllBook();
            } else if (choice.equalsIgnoreCase("3")) {
                // Search Books menu
                System.out.println("\t 1. Book By Id  ");
                System.out.println("\t 2. Book by Name ");
                choice = UserInput();

                // Handling search choices
                if (!(choice.equalsIgnoreCase("exit"))) {
                    if (choice.equalsIgnoreCase("1")) {
                        SearchByID(UserInput());
                    } else if (choice.equalsIgnoreCase("2")) {
                        System.out.println("book by Name will be added ");
                        // SearchBookByName(UserInput());
                    } else {
                        Choice();
                        System.out.println("Give a Valid Input ");
                    }
                }
            } else if (choice.equalsIgnoreCase("version") || choice.equalsIgnoreCase("v")) {
                // Display system version
                Version();
            } else {
                System.out.println("\t\t*****Please Give a valid Input*****");
            }

            System.out.println("\n\n=============================================================\n");
            Choice(); // Recursive call to keep the program running
        }
    }

    /*
     * Method to display the version information
     */
    private void Version() {
        final String filePathOfVersionData = "EnchantedLibrary\\v0.0.1.txt";
        File myObj = new File(filePathOfVersionData);

        int numberOfLines = 0;

        try {
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                numberOfLines++;
                myReader.nextLine(); // Read and discard the line
            }
            myReader.close(); // Close the Scanner
        } catch (Exception e) {
            System.err.println("\t****Error Type : Some Problem To read it****");
        }

        String[] CurrentVersion = new String[numberOfLines]; // Storing The File Info..

        try {
            Scanner myReader = new Scanner(myObj);
            short i = 0;
            while (myReader.hasNextLine()) {
                CurrentVersion[i] = myReader.nextLine(); // Read
                i++;
            }
            myReader.close(); // Close the Scanner
        } catch (Exception e) {
            System.err.println("\t****Error Type : Some Problem To Saving In String[n] ****");
        }

        // Displaying version information
        for (int i = 0; i < CurrentVersion.length; i++) {
            if (CurrentVersion[i] != null) // Just For test
                System.out.println(CurrentVersion[i]);
        }
    }

    /*
     * Main method to start the program
     */
    public static void main(String[] args) {
        new UserControl().Choice(); // Creating an instance and calling the Choice method
    }
}
