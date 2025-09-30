package JavaDev.practice_11;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


//Корректные и некорректные email ("test@example.com", "bad@.com", "no-at-symbol")
//null

public class Task6 {
    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");
    }


    @ParameterizedTest
    @ValueSource(strings = {"test@example.com", "test@mail.ru"})
    public void checkCorrectEmails(String email) {
        assertTrue(isValidEmail(email));
    }

    @ParameterizedTest
    @ValueSource(strings = {"bad@.com", "no-at-symbol", "' '"})
    public void checkIncorrectEmails(String email) {
        assertFalse(isValidEmail(email));
    }

    @Test
    public void checkNullInEmail() {
        assertFalse(isValidEmail(null));
    }
}