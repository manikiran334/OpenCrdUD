package com.opencart.utilities;

import java.net.HttpURLConnection;
import java.net.URL;

public class LinkValidator {

    /**
     * Validates a given hyperlink URL by checking its response code.
     *
     * @param hyperLinkUrl The URL to be validated.
     * @return A string indicating the status of the URL.
     */
    public static String linkValidation(String hyperLinkUrl) {
        String result;
        try {
            URL url = new URL(hyperLinkUrl);
            HttpURLConnection openConnection = (HttpURLConnection) url.openConnection();
            openConnection.setConnectTimeout(5000);
            openConnection.setRequestMethod("GET"); // Ensure we are making a GET request
            openConnection.connect();

            int responseCode = openConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                result = hyperLinkUrl + " : " + responseCode + " (OK)";
            } else {
                result = hyperLinkUrl + " : " + responseCode + " (" + openConnection.getResponseMessage() + ")";
            }
        } catch (Exception e) {
            result = "Exception caught: " + e.getMessage();
        }
        return result;
    }
}
