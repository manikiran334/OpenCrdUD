package com.opencart.utilities;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadingFileUtility {

    /**
     * Downloads a file from the specified URL and saves it to the specified location.
     *
     * @param href The URL from which to download the file.
     * @param fileName The name to save the downloaded file as, including its extension.
     * @throws Exception if an error occurs during the download process.
     */
    public static void downloadFile(String href, String fileName) throws Exception {
        // Establish connection to the provided URL
        URL url = new URL(href);
        URLConnection connection = url.openConnection();

        // Define the file path for saving the downloaded file
        File file = new File("./OutputData/" + fileName);

        // Use try-with-resources to manage input/output streams automatically
        try (BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {

            int byteData;
            // Read from the input stream and write to the output stream byte-by-byte
            while ((byteData = bis.read()) != -1) {
                bos.write(byteData);
            }
            bos.flush();  // Ensure all data is written to the file
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("File download failed", e);
        }
    }
}
