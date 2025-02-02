package FileAccess;

/*
 * here we set up .txt file to read and write data to and from the file...
 * 
 * BASI functions input output functions to read and write data to and from the file
 * 
 * then it will help to read and write for other file systems like .csv ,.xml 
 * 
 */

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileAccess {
    private String filepath;
    private File file;

    public FileAccess(String filepath) {
        // Constructor
        this.filepath = filepath;
        this.file = new File(filepath);
    }

    public boolean isFileExists() {
        return file.exists();
    }

    public void close() {
        // Nothing to close because FileWriter and Scanner are handled locally
        System.out.println("File operations completed.");
    }

    // Read all lines from the file
    public List<String> read() {
        List<String> data = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                data.add(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return data;
    }

    // Read a specific line from the file
    public String read(int line_number) {
        List<String> data = read();
        if (line_number < 0 || line_number >= data.size()) {
            System.out.println("Line number out of bounds.");
            return null;
        }
        return data.get(line_number);
    }

    // Write data to the file (with control over append mode)
    public void write(String data, boolean append) {
        try (FileWriter fileWriter = new FileWriter(file, append)) {
            fileWriter.write(data + System.lineSeparator());
        } catch (Exception e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Write data to the file (default to append mode)
    public void write(String data) {
        write(data, true);
    }

    // Create file if it does not exist
    public void createFile() {
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (Exception e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }

    // Save method to write data to the file
    public void save(String data, boolean append) {
        write(data, append);
        System.out.println("Data saved to file.");
    }

    // Overloaded save method with default append mode
    public void save(String data) {
        save(data, true);
    }

    // public void save() {

    // }

}
