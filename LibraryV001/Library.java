package LibraryV001;

/*
 * Technically its Data Bank where data's are stored 
 * And Can be accessed By LibraryManagementSystem class 
 * 
 */
public class Library {
    // Data of Field
    private final String[] Field = { "Philosphy", "Fiction", "Non-Fiction", "Literature", "Science",
            "Politics", "Biography", "History", "Self-Help", "Programing", "School-Book" };

    // Data Of The book normal
    private String[] BookName = { "Atomic Habbits", "48 Laws of Power", "DO EPIC SHIT", "THE REPUBLIC",
            "THE COMMUNIST MANIFESTO", "Think Like a Monk", "The Origin of Species" };
    private String[] BookWriter = { "James Clear", "Robert Greene", "Ankur Warikoo", "Plato", "Karl Marx",
            "Jay Shetty", "Charles Darwin" };
    private String[] BookID = { "0901", "0902", "0903", "0101", "0601", "0904", "0301" };
    private String[] BookPrice = { "750", "399", "399", "820", "328", "1100", "1300" }; // In Rupee

    // Getter and setters
    // Get Book Data
    // # By Id, Name and Title/Field
    public String GetBookID(int index) {
        return BookID[index];
    }

    public String[] GetBookID() {
        return BookID;
    }

    public String GetBook(int index) {
        return BookName[index];
    }

    public String[] GetBook() {
        return BookName;
    }

    public String GetBookPrice(int index) {
        return BookPrice[index];
    }

    public String[] GetBookWriter() {
        return BookWriter;
    }

    public String GetBookWriter(int index) {
        return BookWriter[index];
    }

    public String[] GetFields() {
        return Field;
    }

    public void AddBookData(String NewBookName, String NewBookWriter, String NewBookPrice, String NewBookID) {
        String[] updatedBookNames = new String[BookName.length + 1];
        String[] updatedBookWriters = new String[BookWriter.length + 1];
        String[] updatedBookIDs = new String[BookID.length + 1];
        String[] updatedBookPrices = new String[BookPrice.length + 1];

        // Copy existing book data to the new arrays
        System.arraycopy(BookName, 0, updatedBookNames, 0, BookName.length);
        System.arraycopy(BookWriter, 0, updatedBookWriters, 0, BookWriter.length);
        System.arraycopy(BookID, 0, updatedBookIDs, 0, BookID.length);
        System.arraycopy(BookPrice, 0, updatedBookPrices, 0, BookPrice.length);

        // Add the new book data to the end of the new arrays
        updatedBookNames[BookName.length] = NewBookName;
        updatedBookWriters[BookWriter.length] = NewBookWriter;
        updatedBookIDs[BookID.length] = NewBookID;
        updatedBookPrices[BookPrice.length] = NewBookPrice;

        // Update the references to point to the new arrays
        BookName = updatedBookNames;
        BookWriter = updatedBookWriters;
        BookID = updatedBookIDs;
        BookPrice = updatedBookPrices;
    }
}