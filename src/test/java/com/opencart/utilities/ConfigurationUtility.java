package com.opencart.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationUtility {

    private Properties properties;

    /**
     * Loads configuration properties from a specified file.
     *
     * @param filePath The path to the properties file.
     * @throws IOException If there is an issue loading the properties.
     */
    public void loadProperties(String filePath) throws IOException {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(filePath)) {
            properties.load(fis);
        }
    }

    /**
     * Gets the value of a property by its key.
     *
     * @param key The key of the property.
     * @return The value of the property, or null if not found.
     */
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
    /**
     * Loads configuration properties from a specified file.
     *
     * @param filePath The path to the properties file.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public ConfigurationUtility(String filePath) throws IOException {
        properties = new Properties();
        FileInputStream input = new FileInputStream(filePath);
        properties.load(input);
    }
    /**
     * Loads the configuration file.
     *
     * @param filePath The path to the properties file.
     */
    public void ConfigReader(String filePath) {
        properties = new Properties();
        try (FileInputStream input = new FileInputStream(filePath)) {
            properties.load(input);
        } catch (IOException e) {
            System.out.println("Error loading configuration file: " + e.getMessage());
        }
    }

}
