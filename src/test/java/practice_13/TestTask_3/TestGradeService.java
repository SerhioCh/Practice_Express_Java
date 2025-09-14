package practice_13.TestTask_3;

import Task_3.GradeService;
import Task_3.InvalidGradeException;
import Task_3.StudentGrade;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestGradeService {
    @Test
    public void checkAddGradeForArray() throws InvalidGradeException {
        GradeService<Double> gradeService = new GradeService<>();
        StudentGrade<Double> expectedStudent = new StudentGrade<>("Serega", "Math", 5.0);
        gradeService.addGrade(expectedStudent);
        assertFalse(gradeService.getStudent().isEmpty());
        assertEquals(gradeService.getStudent().get(0).getGrade(), expectedStudent.getGrade());
    }

    @Test
    public void checkAddNegativeGradeForArray() throws InvalidGradeException {
        GradeService<Double> gradeService = new GradeService<>();
        StudentGrade<Double> expectedStudent = new StudentGrade<>("Serega", "Math", -5.0);
        Exception exception =    assertThrows(InvalidGradeException.class, () -> {
            gradeService.addGrade(expectedStudent);
        });
       assertEquals("Оценка не может быть отрицательной",exception.getMessage());
       assertTrue(gradeService.getStudent().isEmpty());
    }

    @Test
    public  void checkAvgGradeForSubject() throws InvalidGradeException {
        GradeService<Double> gradeService = new GradeService<>();
        gradeService.addGrade(new StudentGrade<>("Serega","Math",10.0));
        gradeService.addGrade(new StudentGrade<>("Vitalya","Math",5.0));
        assertEquals(gradeService.avgGradeForSubject("Math"),7.5);

    }
    @Test
    public  void checkAvgGradeForOneSubject() throws InvalidGradeException {
        GradeService<Double> gradeService = new GradeService<>();
        gradeService.addGrade(new StudentGrade<>("Serega","Math",10.0));
        gradeService.addGrade(new StudentGrade<>("Vitalya","Math",5.0));
        gradeService.addGrade(new StudentGrade<>("Serega","Physics",5.0));
        assertEquals(gradeService.avgGradeForSubject("Physics"),5.0);

    }
    @Test
    public  void checkAvgGradeForException() throws InvalidGradeException {
        GradeService<Double> gradeService = new GradeService<>();
       Exception exception = assertThrows(InvalidGradeException.class,()->{
            gradeService.avgGradeForSubject("Physics");
        });
       assertEquals("Добавьте хоть 1 оценку",exception.getMessage());

    }
}
