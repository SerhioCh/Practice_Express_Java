package practice_11;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

//Пустую строку
//null
//Строку с несколькими пробелами
public class Task9 {
    public static Integer countWords(String sentence) {
        if(sentence==null) {return  null;
        }
        String trimmed = sentence.trim();
        return trimmed.isEmpty() ? 0 : sentence.split("\\s+").length;
    }

    @ParameterizedTest
    @CsvSource({"Serega,1","Pavel Pavel,2","Grom silniy segodnya,3","'',0"})
    public  void checkCountNumbers(String word, int count){
        assertEquals(countWords(word),count);
    }

    @Test
    public  void checkNullCountNumbers(){
        assertNull(countWords(null));
    }

}
