package JavaDevComplexTask.Task_3;

import java.util.ArrayList;
import java.util.List;

public class GradeService <T extends  Number>{
    List<StudentGrade<T>> grades = new ArrayList<>();

    public synchronized void addGrade(StudentGrade<T> grade) throws InvalidGradeException{
        if (grade.getGrade().doubleValue()<0){
 throw  new InvalidGradeException("Оценка не может быть отрицательной");
        }
        grades.add(grade);
    }

    public List<StudentGrade<T>> getStudent(){
        return List.copyOf(grades);
    }

    public  double avgGradeForSubject(String subject) throws InvalidGradeException{
        if (grades.isEmpty()){
            throw  new InvalidGradeException("Добавьте хоть 1 оценку");
        }
       double average =  grades.stream()
                .filter(sub -> sub.getSubject().equals(subject))
                .mapToDouble(grades -> grades.getGrade().doubleValue())
                .average()
                .orElse(0.0);
        return  average;
    }

}
