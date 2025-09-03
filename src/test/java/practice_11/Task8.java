package practice_11;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class Task8 {
    public static int findSecondMax(int[] numbers) {
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
        assertThrows(NoSuchElementException.class, () -> {
            findSecondMax(numbers);
        });
    }

    @Test
    public  void checkExceptionOneElementsInArray(){
        int [] numbers = {5};
        assertThrows(IllegalArgumentException.class, () -> {
            findSecondMax(numbers);
        });
    }
}
