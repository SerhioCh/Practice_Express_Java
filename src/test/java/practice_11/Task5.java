package practice_11;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
//Обычные годы
//Високосные (2020, 2000, 1600)
//Года, которые делятся на 100, но не на 400 (1900, 2100)

public class Task5 {
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    @ParameterizedTest
    @DisplayName("Проверка обычных годов")
    @ValueSource(ints = {2005,2006,2023,1900,2100})
    public  void checkNoLeapYears (int years){
        assertFalse(isLeapYear(years));
    }

    @ParameterizedTest
    @DisplayName("Проверка високосных годов")
    @ValueSource(ints = {2020, 2000, 1600})
    public  void checkLeapYears (int years){
        assertTrue(isLeapYear(years));
    }
}
