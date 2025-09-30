package JavaDev.practice_11;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

//Корректные номера ("+1 1234567890")
//Некорректные номера ("12345", "invalid")
public class Task10 {
    public static boolean isValidPhoneNumber(String phone) {
        return phone.matches("\\+\\d{1,3} \\d{10}");
    }

    @ParameterizedTest
    @ValueSource(strings = {"+1 1234567890","+7 1234567890","+5 1234567890"})
    public  void checkCorrectNumbers(String numbers){
        assertTrue(isValidPhoneNumber(numbers));
    }

    @ParameterizedTest
    @ValueSource(strings = {"14325","invalid"," "})
    public  void checkIncorrectNumbers(String numbers){
        assertFalse(isValidPhoneNumber(numbers));
    }
}
