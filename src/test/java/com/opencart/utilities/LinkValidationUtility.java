package com.opencart.utilities;

import java.net.HttpURLConnection;
import java.net.URL;

public class LinkValidationUtility {

    /**
     * Validates a hyperlink URL by checking the HTTP response code.
     *
     * @param hyperLinkUrl The URL to validate.
     * @return A string indicating the URL and its HTTP response status or any exception encountered.
     */
    public static String linkValidation(String hyperLinkUrl) {
        String result = "";
        try {
            // Create URL object from the hyperlink string
            URL url = new URL(hyperLinkUrl);

            // Open connection and set timeout
            HttpURLConnection openConnection = (HttpURLConnection) url.openConnection();
            openConnection.setConnectTimeout(5000);
            openConnection.connect();

            // Check HTTP response code
            if (HttpURLConnection.HTTP_OK == openConnection.getResponseCode()) {
                result = hyperLinkUrl + " : " + openConnection.getResponseCode();
            } else {
                result = hyperLinkUrl + " : " + openConnection.getResponseMessage();
            }
        } catch (Exception e) {
            // Handle exceptions such as invalid URL or connection issues
            result = "Exception caught: " + e.getMessage();
        }
        return result;
    }
}
