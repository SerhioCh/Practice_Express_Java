package JavaDev.practice_11;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class Task8 {
    public static int findSecondMax(int[] numbers) {
        if(numbers.length<2){
            throw  new IllegalArgumentException("Добавьте больше 1 числа в массив");
        }
        if (Arrays.stream(numbers).distinct().count()<2){
            throw  new IllegalArgumentException("Недостаточно уникальных чисел");
        }
        return Arrays.stream(numbers).distinct().sorted().skip(numbers.length - 2).findFirst().orElseThrow();
    }


    @Test
    public  void checkSecondMaxNumberInArray(){
        int [] numbers = {3,6,8,10,15};
        assertEquals(findSecondMax(numbers),10);
    }
    @Test
    public  void checkExceptionInIdenticalNumberArray(){
        int [] numbers = {5,5,5,5,5};
       IllegalArgumentException exception =  assertThrows(IllegalArgumentException.class, () -> {
            findSecondMax(numbers);
        });
       assertEquals("Недостаточно уникальных чисел",exception.getMessage());
    }

    @Test
    public  void checkExceptionOneElementsInArray(){
        int [] numbers = {5};
        IllegalArgumentException  exception =    assertThrows(IllegalArgumentException.class, () -> {
            findSecondMax(numbers);
        });
        assertEquals("Добавьте больше 1 числа в массив",exception.getMessage());
    }
    @Test
    public void checkExceptionEmptyArray() {
        int[] numbers = {};

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            findSecondMax(numbers);
        });

        assertEquals("Добавьте больше 1 числа в массив", exception.getMessage());
    }
}
