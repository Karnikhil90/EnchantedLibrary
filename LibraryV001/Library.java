package LibraryV001;

/*
 * Technically its Data Bank where data's are stored 
 * And Can be accessed By LibraryManagementSystem class 
 * 
 */
public class Library {
    // public static final String[] GetBook = null;

    // Data of Field
    private final String[] Field = { "Philosphy", "Fiction", "Non-Fiction", "Mystery", "Science",
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

}