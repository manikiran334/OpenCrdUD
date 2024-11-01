package com.opencart.utilities;

import java.util.Random;

public class RandomDataUtility {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int NAME_LENGTH = 8;

    /**
     * Generates a random string of specified length.
     *
     * @param length The length of the random string.
     * @return A random string.
     */
    public String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        return sb.toString();
    }

    /**
     * Generates a random email address.
     *
     * @return A random email address.
     */
    public String generateRandomEmail() {
        String randomString = generateRandomString(NAME_LENGTH);
        return randomString + "@example.com";
    }

    /**
     * Generates a random number.
     *
     * @param upperBound The upper limit for the random number generation.
     * @return A random number between 0 and the specified upper bound.
     */
    public int generateRandomNumber(int upperBound) {
        Random random = new Random();
        return random.nextInt(upperBound);
    }
    private Random random = new Random();

    /**
     * Generates a random integer within a specified range.
     *
     * @param min The minimum value (inclusive).
     * @param max The maximum value (exclusive).
     * @return A random integer between min (inclusive) and max (exclusive).
     */
    public int getRandomInteger(int min, int max) {
        return random.nextInt(max - min) + min;
    }
}
