package com.opencart.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtility {

    /**
     * Reads the content of a specified file.
     *
     * @param filePath The path of the file to read.
     * @return The content of the file as a String.
     * @throws IOException If an I/O error occurs.
     */
    public String readFileContent(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
    /**
     * Writes the given content to a file.
     *
     * @param filePath The path to the file where the content will be written.
     * @param content  The content to write to the file.
     * @throws IOException If there is an issue writing to the file.
     */
    public void writeFile(String filePath, String content) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
        }
    }
}
