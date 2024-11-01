package com.opencart.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class LinkUtility {

    /**
     * Retrieves all link URLs on the current page.
     *
     * @param driver The WebDriver instance to control the browser.
     * @return A list of URLs from all anchor tags on the page.
     */
    public List<String> getAllLinks(WebDriver driver) {
        List<String> links = new ArrayList<>();
        List<WebElement> anchorElements = driver.findElements(By.tagName("a"));
        for (WebElement anchor : anchorElements) {
            String href = anchor.getAttribute("href");
            if (href != null && !href.isEmpty()) {
                links.add(href);
            }
        }
        return links;
    }
}
