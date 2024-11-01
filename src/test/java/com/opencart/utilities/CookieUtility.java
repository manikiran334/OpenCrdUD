package com.opencart.utilities;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class CookieUtility {

    /**
     * Adds a cookie to the browser.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param cookieName The name of the cookie.
     * @param cookieValue The value of the cookie.
     */
    public void addCookie(WebDriver driver, String cookieName, String cookieValue) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        driver.manage().addCookie(cookie);
    }

    /**
     * Retrieves all cookies from the browser.
     *
     * @param driver The WebDriver instance to control the browser.
     * @return A set of cookies from the browser.
     */
    public Set<Cookie> getAllCookies(WebDriver driver) {
        return driver.manage().getCookies();
    }

    /**
     * Deletes all cookies in the current browser session.
     *
     * @param driver The WebDriver instance to control the browser.
     */
    public void deleteAllCookies(WebDriver driver) {
        driver.manage().deleteAllCookies();
    }
    /**
     * Deletes a cookie by its name.
     *
     * @param driver The WebDriver instance to control the browser.
     * @param cookieName The name of the cookie to delete.
     */
    public void deleteCookieByName(WebDriver driver, String cookieName) {
        driver.manage().deleteCookieNamed(cookieName);
    }

}
