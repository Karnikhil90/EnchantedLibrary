package LibraryV002.BookData;

import java.util.Arrays;

/*
 * Technically its Data Bank where data's are stored 
 * And Can be accessed By LibraryManagementSystem class 
 * 
 */
public class Library extends FileAccess {
    // Data of Field
    private final String[] Field = { "Philosphy", "Fiction", "Non-Fiction", "Literature", "Science",
            "Politics", "Biography", "History", "Self-Help", "Programing", "School-Book", "autobiography",
            "biography", "Nobles", "Religious" };
    private final String pathOfData = "LibraryV002\\BookData\\book_inventory.txt";

    // Data Of The book normal
    private String[] BookName;
    private String[] BookWriter;
    private String[] BookID;
    private String[] BookPrice; // In Rupee
    private String[] RecivedUserData;
    private String CombineBookData;
    private int numberOflines = 0;

    public Library() {
        SetData();
    }

    private void SetData() {
        numberOflines = readNumberOfLinesFileInfo(pathOfData);
        BookName = new String[numberOflines];
        BookWriter = new String[numberOflines];
        BookID = new String[numberOflines];
        BookPrice = new String[numberOflines];
        RecivedUserData = readAndDisplayFileInfo(pathOfData);
        int i = 0; // Index for the original array
        int j = 0; // Index for the new array without null values

        while (i < numberOflines && j < numberOflines) {
            String str = RecivedUserData[i];

            if (str != null && !str.trim().isEmpty()) {
                String[] temp = str.split(",");

                try {
                    // Check for null or empty values before assigning to arrays
                    if (temp != null && temp.length >= 4
                            && temp[0] != null && !temp[0].trim().equals("")
                            && temp[1] != null && !temp[1].trim().equals("")
                            && temp[2] != null && !temp[2].trim().equals("")
                            && temp[3] != null && !temp[3].trim().equals("")) {
                        BookName[j] = temp[0].trim();
                        BookWriter[j] = temp[1].trim();
                        BookPrice[j] = temp[2].trim();
                        BookID[j] = temp[3].trim();
                        j++;
                    }
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
            i++;
        }

        // Adjust the size of arrays based on the valid elements
        numberOflines = j;
        BookName = Arrays.copyOf(BookName, numberOflines);
        BookWriter = Arrays.copyOf(BookWriter, numberOflines);
        BookPrice = Arrays.copyOf(BookPrice, numberOflines);
        BookID = Arrays.copyOf(BookID, numberOflines);
    }

    // Getter and setters
    // Get Book Data
    // # By Id, Name and Title/Field

    public String[] GetBookID() {
        return BookID;
    }

    /*
     * overloaded Or Polymorphism
     */
    public String GetBookID(int index) {
        return BookID[index];
    }

    /*
     * overloaded Or Polymorphism
     */
    public String GetBook(int index) {
        return BookName[index];
    }

    public String[] GetBook() {
        return BookName;
    }

    /*
     * overloaded Or Polymorphism
     */
    public String GetBookPrice(int index) {
        return BookPrice[index];
    }

    public String[] GetBookWriter() {
        return BookWriter;
    }

    /*
     * overloaded Or Polymorphism
     */
    public String GetBookWriter(int index) {
        return BookWriter[index];
    }

    public String[] GetFields() {
        return Field;
    }

    public void AddBookData(String NewBookName, String NewBookWriter, String NewBookPrice, String NewBookID) {
        String CombineBookData = NewBookName + "," + NewBookWriter + "," + NewBookPrice + "," + NewBookID;
        writeAndDisplayFileInfo(pathOfData, CombineBookData);
        SetData();
    }
}