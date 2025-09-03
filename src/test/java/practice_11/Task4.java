package practice_11;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.NoSuchElementException;

//Обычный массив ([3, 5, 7, 2])
//Один элемент в массиве
//Отрицательные числа
//Пустой массив (должно выбрасываться исключение)
public class Task4 {
    public int findMax(int[] numbers) {
        return Arrays.stream(numbers).max().orElseThrow();
    }
    @Test
    public  void checkMaxValueInArray(){
        int [] numbers = {3,6,10,14,2};
        assertEquals(findMax(numbers),14);
    }
    @Test
    public  void checkOneElementsInArray(){
        int [] numbers = {14};
        assertEquals(findMax(numbers),14);
    }
    @Test
    public  void checkMaxNegativeValueInArray(){
        int [] numbers = {-14,-2,-56,-25};
        assertEquals(findMax(numbers),-2);
    }

    @Test
    public  void checkExceptionInEmptyArray(){
        assertThrows(NoSuchElementException.class, ()-> {
            int [] numbers = {};
            findMax(numbers);
        });
    }



}
