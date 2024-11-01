package com.opencart.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigDataProvider {
    private Properties properties;
    private static final Logger logger = Logger.getLogger(ConfigDataProvider.class.getName());

    /**
     * Constructor that loads the configuration properties from a file.
     */
    public ConfigDataProvider() {
        File src = new File("./Configuration/config.properties");
        try (FileInputStream fis = new FileInputStream(src)) {
            properties = new Properties();
            properties.load(fis);
            logger.info("Configuration file loaded successfully.");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Not able to load config file: " + e.getMessage(), e);
        }
    }

    /**
     * Gets the browser name from the configuration.
     *
     * @return The browser name as a String.
     */
    public String getBrowser() {
        String browser = properties.getProperty("browser");
        if (browser == null) {
            logger.warning("Browser property not found in the configuration file.");
        }
        return browser;
    }

    /**
     * Gets the staging URL from the configuration.
     *
     * @return The staging URL as a String.
     */
    public String getStagingUrl() {
        String stagingUrl = properties.getProperty("testurl");
        if (stagingUrl == null) {
            logger.warning("Staging URL property not found in the configuration file.");
        }
        return stagingUrl;
    }
}
