package LibraryV002.BookData;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileAccess {

    public int readNumberOfLinesFileInfo(String FileName) {
        File myObj = new File(FileName);
        int numberOfLines = 0;
        int numberOfBlanks = 0;

        try {
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();

                // Check if the line is blank or contains only whitespaces
                if (line.trim().isEmpty()) {
                    numberOfBlanks++;
                }
                numberOfLines++;
            }

            myReader.close(); // Close the Scanner
        } catch (Exception e) {
            System.err.println("\t****Error Type: Some Problem To read it****");
        }
        // ?DEBUG: System.out.println(numberOfBlanks);
        return numberOfLines;
    }

    public String[] readAndDisplayFileInfo(String fileName) {
        File myObj = new File(fileName);

        int numberOfLines = readNumberOfLinesFileInfo(fileName);
        String[] fileContents = new String[numberOfLines]; // Storing The File Info..

        try {
            Scanner myReader = new Scanner(myObj);
            int i = 0;
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                if (!line.isEmpty()) {
                    fileContents[i] = line; // Read and add non-empty lines
                    i++;
                }
            }
            myReader.close(); // Close the Scanner
        } catch (Exception e) {
            System.err.println("\t****Error Type: Some Problem To Saving In String[n] ****");
            System.out.println(e.getMessage());
        }
        return fileContents;
    }

    public void writeAndDisplayFileInfo(String FileName, String DataToAddInFile) {
        try {
            FileWriter writter = new FileWriter(FileName, true);
            writter.write('\n' + DataToAddInFile + '\n');
            writter.close();
            System.out.println("Added The Content ");

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void writeAndDisplayFileInfo(String FileName, String DataToAddInFile, boolean append_) {
        try {
            FileWriter writter = new FileWriter(FileName, append_);
            writter.write('\n' + DataToAddInFile + '\n');
            writter.close();
            System.out.println("Added The Content ");

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
