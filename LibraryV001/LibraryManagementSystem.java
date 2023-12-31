package LibraryV001;

// import java.util.Scanner;

/*
 * This is the main which Works the most 
 * This class contains all the functionality 
 * This class access the 'library' to get data From The Library
 * 
*/
public class LibraryManagementSystem {

    private Library LibraryObj;
    // private static Scanner input;

    LibraryManagementSystem() {
        LibraryObj = new Library();
        // input = new Scanner(System.in);
    }

    // Search By ID
    public void SearchByID(String id) {
        String[] ReciveBookId = LibraryObj.GetBookID();
        int key = -1; // Default Value
        for (int i = 0; i < ReciveBookId.length; i++) {
            if (ReciveBookId[i].equals(id)) {
                key = i;
                break;
            }
        }
        DisplayBook(key);
    }

    // Display all the book
    public void DisplayAllBook() {
        // Filter will be added in future

        // All The Data Get
        final String[] name = LibraryObj.GetBook();
        final String[] id = LibraryObj.GetBookID();
        final String[] writer = LibraryObj.GetBookWriter();
        // Prise of the book
        String[] price = new String[name.length];
        for (int i = 0; i < price.length; i++) {
            price[i] = LibraryObj.GetBookPrice(i);
        }

        // Displaing the books
        System.out.println("\n\t\t****All The Books are here****\n\n");
        for (int i = 0; i < name.length; i++) {
            System.out.println("=============================================================");
            System.out.println("Name : '" + name[i] + "'" + " by : '" + writer[i] + "'");
            System.out.println("Id : " + id[i] + "\tPrice : " + price[i]);
            System.out.println("=============================================================");
        }
    }

    // Display Specific Book
    public void DisplayBook(int index) {
        String name = LibraryObj.GetBook(index);
        String writer = LibraryObj.GetBookWriter(index);
        String id = LibraryObj.GetBookID(index);
        String price = LibraryObj.GetBookPrice(index);

        System.out.println("\n\n\n=============================================================");
        System.out.println("Name : '" + name + "'" + " by : '" + writer + "'");
        System.out.println("Id : " + id + "\tPrice : " + price);
        System.out.println("=============================================================");
    }

    public void SearchBookByName(String nameofbook) {// NOT WORKING
        String[] bookList = LibraryObj.GetBook();
        final String[] bookSearch = nameofbook.split(" ");

        for (int i = 0; i < bookList.length; i++) {
            String[] newBookname = (" " + bookList[i]).split(" ");
            for (int j = 0; j < newBookname.length; j++) {
                if (newBookname[j].equalsIgnoreCase(bookSearch[0])
                        || newBookname[j].equalsIgnoreCase(bookSearch[1])) {
                    System.out.println("Index" + i);
                    break;
                }
            }
        }
    }

}