package FileAccess;

import java.util.*;

public class MyCSV {
    private FileAccess fileAccess;

    public MyCSV(String filepath) {
        fileAccess = new FileAccess(filepath);

        if (!fileAccess.isFileExists()) {
            fileAccess.createFile();
            fileAccess.write(filepath);
        }
    }

    // Create CVS file and here i will pass just hearder as @List<String>
    public void create(List<String> hearder) {
        fileAccess.write(String.join(",", hearder));
    }

    /*
     * write(String data) : but this will cheak if the file have index hearder
     * then it will append the index automatically just by recored
     * from reading the
     * 
     * example how it will be
     * data : "<name>,<author>,<price>,<id>"
     * 
     * but this write field will take care of auto appending the
     * index
     * 
     * suppose the data is
     * ```cvs
     * index , "name,author,price,id"
     * 1 "<name>,<author>,<price>"
     * 2 "<name>,<author>,<price>"
     * 3 "<name>,<author>,<price>"
     * ```
     * here the index is generated by the MyCSV class similar to sql
     * auto increment
     * 
     */
    public void write(String data) {
        List<String> header = hearder();
        List<String> rows = fileAccess.read();

        // if (header.get(0).equals("index") || rows.size() != 0)
        if (header.get(0).equals("index")) {
            String lastRow = rows.get(rows.size() - 1);
            String[] lastRowArray = lastRow.split(",");
            int index = Integer.parseInt(lastRowArray[0]) + 1;
            fileAccess.write(index + "," + data);
        } else {
            fileAccess.write("", false); // clear the file
            fileAccess.write("index," + header.toString());
            for (String row : rows) {
                write(row);
            }
        }

        if (rows.size() == 0) {
            fileAccess.write(1 + "," + data);
        } else {

        }
    }

    // o(n)
    public void raw_write(String data) {
        fileAccess.write(data);
    }

    public List<String> read() {
        return fileAccess.read();
    }

    // o(n)
    public List<String> hearder() {
        String data = fileAccess.read(0);
        List<String> hearder = Arrays.asList(data.split(","));
        return hearder;
    }

    // o(n^2)
    public List<Map<String, String>> toMap() {
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        List<String> hearder = hearder();
        List<String> rows = fileAccess.read();

        for (String row : rows) {
            Map<String, String> rowMap = new HashMap<String, String>();
            List<String> rowList = Arrays.asList(row.split(","));
            for (int i = 0; i < hearder.size(); i++) {
                rowMap.put(hearder.get(i), rowList.get(i));
            }
            data.add(rowMap);
        }
        return data;
    }

    // o(n)
    public void writeAll(List<String> data) {
        for (String line : data) {
            fileAccess.write(line + "\n");
        }
    }

    public void close() {
        fileAccess.close();
    }

    // update(condition, data): condition will be the id maybe like where this is
    // that or something like that
    public void update(String condition, Map<String, String> data) {
        List<Map<String, String>> rows = toMap();
        List<String> hearder = hearder();
        List<String> newRows = new ArrayList<String>();

        for (Map<String, String> row : rows) {
            if (row.get(condition) != null) {
                for (int i = 0; i < hearder.size(); i++) {
                    if (data.get(hearder.get(i)) != null) {
                        row.put(hearder.get(i), data.get(hearder.get(i)));
                    }
                }
            }
            newRows.add(String.join(",", row.values()));
        }

        fileAccess.write("");
        writeAll(newRows);
    }

}