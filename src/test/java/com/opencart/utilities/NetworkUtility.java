package com.opencart.utilities;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkUtility {

    /**
     * Checks if a URL is reachable.
     *
     * @param urlString The URL to check.
     * @return true if the URL is reachable, false otherwise.
     * @throws IOException If there is an issue with the connection.
     */
    public boolean isUrlReachable(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("HEAD");
        connection.setConnectTimeout(5000);
        connection.connect();
        return connection.getResponseCode() == 200;
    }
}
