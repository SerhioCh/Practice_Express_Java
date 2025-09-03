package practice_11;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

//Обычные строки
//Пустую строку
//null (должно возвращаться null)
public class Task3 {
    public static String reverse(String input) {
        if (input == null) return null;
        return new StringBuilder(input).reverse().toString();
    }

    public static Stream <Arguments> validStringReverse(){
        return Stream.of(
                Arguments.of("serega","ageres"),
                Arguments.of("madam","madam"),
                Arguments.of("",""),
                Arguments.of(null,null));
    }

    @ParameterizedTest
    @MethodSource("validStringReverse")
    public  void checkReverseString(String initialString , String expectedString){
        assertEquals(reverse(initialString),expectedString);
    }

}
// Тесты стоит разбить на   Позитивные (строки + пустая строка) и на негативный null   - сделал все в одном для экономии времени