package practice_11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

//Разные строки ("hello", "java", "AEIOU", "")
//null (должно выбрасываться исключение)
//Строки без гласных
public class Task2 {
    public static int countVowels(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        return (int) input.toLowerCase().chars()
                .filter(c -> "aeiou".indexOf(c) != -1)
                .count();
    }

    @ParameterizedTest
    @DisplayName("Проверка количества гласных букв в слове")
    @CsvSource({"hello,2","java,2","AEIOU,5","'',0","bddfd,0"})
    public void checkVowelsIntString(String word,int value){
        assertEquals(countVowels(word),value);
    }

    @Test
    public  void checkExceptionOnNull(){
        assertThrows(IllegalArgumentException.class, () -> {
            countVowels(null);
        });
    }

}
