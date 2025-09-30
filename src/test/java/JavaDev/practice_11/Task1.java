package JavaDev.practice_11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;


// Чётные и нечётные числа
//Нулевое значение
//Отрицательные числа
public class Task1 {
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    @ParameterizedTest
    @DisplayName("Проверка четных чисел включая отрицательные и 0")
    @ValueSource(ints = {0,2,6,-2})
    public  void checkNumbersIsEven(int numbers){
        assertTrue(isEven(numbers));
    }

    @ParameterizedTest
    @DisplayName("Проверка нечетных чисел включая отрицательные")
    @ValueSource(ints = {1,3,9,-3})
    public  void checkNumbersIsNotEven(int numbers){
        assertFalse(isEven(numbers));
    }

}
