package practice_middle.generator;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomData {
    private RandomData() {
    }

    public static String getUserName() {
        return RandomStringUtils.randomAlphabetic(10);
    }

    public static String getUserPassword() {
        return RandomStringUtils.randomAlphabetic(3).toUpperCase() +
                RandomStringUtils.randomAlphabetic(5).toLowerCase() +
                RandomStringUtils.randomNumeric(3).toLowerCase() + "!";
    }
}
