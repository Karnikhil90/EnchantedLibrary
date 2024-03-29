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

    public String toTitle(String data) {
        String[] recivedData = data.toLowerCase().split(" ");
        String result = "";

        for (int i = 0; i < recivedData.length; i++) {
            result += " " + recivedData[i].toUpperCase().charAt(0) + recivedData[i].substring(1);
        }
        return result.trim();
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
        final String[] name = LibraryObj.GetBook();

        // Displaing the books
        System.out.println("\n\t\t****All The Books are here****\n\n");
        for (int i = 0; i < name.length; i++) {
            DisplayBook(i);
        }
    }

    // Display Specific Book
    public void DisplayBook(int index) {
        String name = LibraryObj.GetBook(index);
        String writer = LibraryObj.GetBookWriter(index);
        String id = LibraryObj.GetBookID(index);
        String price = LibraryObj.GetBookPrice(index);

        System.out.println("=============================================================");
        System.out.println("Name : '" + toTitle(name) + "'" + " by : '" + toTitle(writer) + "'");
        System.out.println("Id : " + id + "\tPrice : " + price);
        System.out.println("=============================================================");
    }

    public void SearchBookByName(String nameofbook) {
        String[] bookList = LibraryObj.GetBook();

        int cheakGetOrNot = -1;
        for (int mainINDEX = 0; mainINDEX < bookList.length; mainINDEX++) {
            for (String book : bookList[mainINDEX].split(" ")) {
                for (String recivedBook : nameofbook.split(" ")) {
                    if (recivedBook.equalsIgnoreCase(book)) {
                        DisplayBook(mainINDEX);
                        cheakGetOrNot = mainINDEX;
                        break;
                    }

                }
            }
        }
        if (cheakGetOrNot == -1) {
            System.err.println("\n\t****ErrorType: Book Doesnt Exist****");
        }
    }

    public void AddbookByUser(String NewBookName, String NewBookWriter, String NewBookPrice, String NewBookID) {
        byte passOrNot = -1;
        if (!(NewBookName.length() > 0 && NewBookName.length() < 50)) {
            passOrNot++;
            System.err.println("***ErrorType: The length of the book Name must be under 50 characters***");
        }
        if (!(NewBookWriter.length() > 0 && NewBookWriter.length() < 50)) {
            passOrNot++;
            System.err.println("***ErrorType: The length of the book Author must be under 50 characters***");

        }
        try {
            if (NewBookWriter != null && NewBookWriter != "") {
                if (!(Integer.valueOf(NewBookPrice) > 0))
                    passOrNot++;
            }
        } catch (Exception e) {
            passOrNot++;
            System.err.println("****ErrorType: " + e.getClass() + " ****");
        }
        if (passOrNot == -1) {
            if (Integer.valueOf(NewBookID) < 10) { // ! '$$' is for the last value is not decided yet
                NewBookID = "0" + NewBookID + "$$";
            } else {
                NewBookID = NewBookID + "$$";
            }

            LibraryObj.AddBookData(NewBookName.toUpperCase(), NewBookWriter.toUpperCase(), NewBookPrice, NewBookID);
            System.out.println("New Book Successfully Added");
        } else {
            System.out.println("\t***Error: New Book Not accepted***");
        }
    }

}