package FileAccess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MyCSV {
    private FileAccess fileAccess;

    public MyCSV(String filepath) {
        fileAccess = new FileAccess(filepath);

        if (!fileAccess.isFileExists()) {
            System.out.println("File not found, creating new file...");
            fileAccess.createFile();
        } else {
            System.out.println("MyCSV : File found");
        }
    }

    public List<String> header() {
        try {
            String data = fileAccess.read(0);
            if (data == null || data.isEmpty()) {
                System.out.println("Header is empty or not found.");
                return new ArrayList<>();
            }
            return new ArrayList<>(Arrays.asList(data.split(",")));
        } catch (Exception e) {
            System.out.println("Error reading header: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void create(List<String> header) {
        List<String> new_header = new LinkedList<>(header);
        if (!new_header.isEmpty() && !new_header.get(0).equals("index")) {
            // header.add(0, "index");
            fileAccess.write(String.join(",", new_header));
        }

    }

    public void write(String data) {
        List<String> rows = fileAccess.read();

        int index = 1; // Default to 1 if empty

        if (!rows.isEmpty()) {
            String lastRow = rows.get(rows.size() - 1);
            String[] lastRowArray = lastRow.split(",");

            try {
                index = Integer.parseInt(lastRowArray[0]) + 1;
            } catch (NumberFormatException e) {
                System.out.println("Error parsing index. Resetting to 1.");
            }
        }

        fileAccess.write(index + "," + data);
    }

    public void rawWrite(String data) {
        fileAccess.write(data);
    }

    public List<String> read() {
        return fileAccess.read();
    }

    public List<Map<String, String>> toMap() {
        List<Map<String, String>> data = new ArrayList<>();
        List<String> header = header();
        List<String> rows = fileAccess.read();

        if (header.isEmpty()) {
            System.out.println("Error: No header available.");
            return data;
        }

        for (String row : rows) {
            String[] rowArray = row.split(",");
            if (rowArray.length != header.size()) {
                System.out.println("Skipping malformed row: " + row);
                continue;
            }
            Map<String, String> rowMap = new HashMap<>();
            for (int i = 0; i < header.size(); i++) {
                rowMap.put(header.get(i), rowArray[i]);
            }
            data.add(rowMap);
        }
        return data;
    }

    public void writeAll(List<String> data) {
        fileAccess.write("", false); // Clear file first
        for (String line : data) {
            fileAccess.write(line);
        }
    }

    public void close() {
        fileAccess.close();
    }

    public void update(String conditionKey, String conditionValue, Map<String, String> newData) {
        List<Map<String, String>> rows = toMap();
        List<String> header = header();
        List<String> newRows = new ArrayList<>();

        if (header.isEmpty()) {
            System.out.println("Error: No header found.");
            return;
        }

        newRows.add(String.join(",", header)); // Add header

        for (Map<String, String> row : rows) {
            if (row.get(conditionKey) != null && row.get(conditionKey).equals(conditionValue)) {
                for (String key : newData.keySet()) {
                    if (row.containsKey(key)) {
                        row.put(key, newData.get(key));
                    }
                }
            }
            newRows.add(String.join(",", row.values()));
        }

        writeAll(newRows);
    }

    public List<String> get(String columnName) {
        List<Map<String, String>> records = toMap();
        List<String> columnValues = new ArrayList<>();

        for (Map<String, String> record : records) {
            if (record.containsKey(columnName)) {
                columnValues.add(record.get(columnName));
            }
        }
        return columnValues;
    }

    public void save(String data, boolean append) {
        fileAccess.save(data, append);
    }
}
