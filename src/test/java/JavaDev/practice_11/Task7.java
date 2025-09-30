package JavaDev.practice_11;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
//0! = 1
//Маленькие числа (1!, 5!, 7!)
//Отрицательные числа (должно выбрасываться исключение)
public class Task7 {

    public static   int factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative numbers not allowed");
        return (n == 0) ? 1 : n * factorial(n - 1);
    }

    @ParameterizedTest
    @CsvSource({"0,1","1,1","5,120","7,5040"})
    public  void  checkFactorialNumbers(int number, int factorial){
        assertEquals(factorial(number),factorial);
    }

    @Test
    public  void checkExceptionOnNegativeNumbers(){
        assertThrows(IllegalArgumentException.class, ()->{
            factorial(-10);
        });
    }
}
