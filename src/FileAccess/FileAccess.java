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
import java.util.*;
import java.io.FileWriter;

public class FileAccess {
    private String filepath;
    private File file;
    private FileWriter fileWriter;
    private Scanner scanner;

    FileAccess(String filepath) {
        // constructor
        this.filepath = filepath;
        file = new File(filepath);
        try {
            fileWriter = new FileWriter(file);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public boolean isFileExists() {
        return file.exists();
    }

    public void close() {
        // close the file
        try {
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    // basic read from the .txt file
    public List<String> read() {
        // read data from file
        List<String> data = new ArrayList<String>();
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                data.add(scanner.nextLine());
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return data;
    }

    public String read(int line_number) {
        List<String> data = read();
        return data.get(line_number);
    }

    // it will write normally into txt files
    public void write(String data, boolean append) {
        // write data to file
        try {
            fileWriter = new FileWriter(file, append);
            fileWriter.write(data);
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void write(String data) {
        write(data, true);
    }

    // Create file if not exists
    public void createFile() {
        try {
            file.createNewFile();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
