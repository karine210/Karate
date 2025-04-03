/*package utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonConcatenator {
    public static void concatenateJsonFiles(String inputFolderPath, String outputFilePath) throws IOException {
        JSONArray combinedArray = new JSONArray();
        File folder = new File(inputFolderPath);

        if (!folder.exists() || !folder.isDirectory()) {

            // Debug information

            System.out.println(folder);
            System.err.println("Error: Input path is not a valid directory");
            System.err.println("Current working directory: " + System.getProperty("user.dir"));

            File currentDir = new File(System.getProperty("user.dir"));
            System.err.println("Files in current directory:");
            File[] currentFiles = currentDir.listFiles();
            if (currentFiles != null) {
                for (File f : currentFiles) {
                    System.err.println((f.isDirectory() ? "[DIR] " : "[FILE] ") + f.getName());
                }
            }

            throw new IOException("Input path is not a valid directory");


        }

        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".json"));

        if (files == null || files.length == 0) {
            System.out.println("No JSON files found in the directory");
            return;
        }

        for (File file : files) {
            try (FileReader reader = new FileReader(file)) {
                JSONTokener tokener = new JSONTokener(reader);
                Object json = tokener.nextValue();

                if (json instanceof JSONArray) {
                    JSONArray array = (JSONArray) json;
                    for (int i = 0; i < array.length(); i++) {
                        combinedArray.put(array.get(i));
                    }
                } else if (json instanceof JSONObject) {
                    combinedArray.put(json);
                }
            } catch (IOException e) {
                System.err.println("Error reading file " + file.getName() + ": " + e.getMessage());
            }
        }

        try (FileWriter writer = new FileWriter(outputFilePath)) {
            writer.write(combinedArray.toString(4)); // 4 spaces for indentation
            System.out.println("Successfully concatenated JSON files to " + outputFilePath);
        }
    }

    public static void main(String[] args) {
        try {
            // Example usage
            concatenateJsonFiles("target/surefire-reports/", "target/combined.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}*/