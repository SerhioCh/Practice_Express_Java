package JavaDev.practice_13.TestTask_1;

import Task_1.EntityManager;
import Task_1.Student;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import  static  org.junit.jupiter.api.Assertions.*;

public class EntityTest {
    @Test
    public  void checkAddEntityForArray(){
        EntityManager <Student> manager = new EntityManager<>();
        Student expectedStudent = new Student("Serega",18,true);
        manager.addEntity(expectedStudent);
        assertEquals(manager.getAllEntity().size(),1);
        assertEquals(manager.getAllEntity().get(0).getName(),expectedStudent.getName());
        assertEquals(manager.getAllEntity().get(0).getAge(),expectedStudent.getAge());
        assertEquals(manager.getAllEntity().get(0).isActive(),expectedStudent.isActive());
    }
    @Test
    public void checkRemoveEntity(){
        EntityManager <Student> manager = new EntityManager<>();
        Student expectedStudent = new Student("Serega",18,true);
        manager.addEntity(expectedStudent);
        manager.removeEntity(expectedStudent);
        assertTrue(manager.getAllEntity().isEmpty());

        manager.addEntity(new Student("Serega",18,true));
        manager.addEntity(new Student("Alex",22,false));
        manager.removeEntity(manager.getAllEntity().get(1));
        assertEquals(manager.getAllEntity().size(),1);
    }

    @Test
    public void checkAgeFilter(){
        EntityManager <Student> manager = new EntityManager<>();
        manager.addEntity(new Student("Serega",18,true));
        manager.addEntity(new Student("Alex",30,false));
        manager.addEntity(new Student("Vasya",65,false));
        manager.addEntity(new Student("Petya",15,false));
        manager.addEntity(new Student("Vel",5,false));

        List <Student> filtred = manager.getAllEntity().stream()
                .filter(a -> a.getAge()>=18 && a.getAge()<=30)
                .collect(Collectors.toList());
        assertEquals(manager.filtredByAge(18,30),filtred);
    }

    @Test
    public void checkNameFilter(){
        EntityManager <Student> manager = new EntityManager<>();
        manager.addEntity(new Student("Serega",18,true));
        manager.addEntity(new Student("Alex",30,false));
        manager.addEntity(new Student("Vasya",65,false));
        manager.addEntity(new Student("Petya",15,false));
        manager.addEntity(new Student("Vel",5,false));

        List <Student> filtred = manager.getAllEntity().stream()
                .filter(a -> a.getName().equals("Serega"))
                .collect(Collectors.toList());
        assertEquals(manager.filtredByName("Serega"),filtred);
    }


    @Test
    public void checkIsActiveFilter(){
        EntityManager <Student> manager = new EntityManager<>();
        manager.addEntity(new Student("Serega",18,true));
        manager.addEntity(new Student("Alex",30,false));
        manager.addEntity(new Student("Vasya",65,true));
        manager.addEntity(new Student("Petya",15,false));
        manager.addEntity(new Student("Vel",5,true));

        List <Student> filtred = manager.getAllEntity().stream()
                .filter(a -> a.isActive())
                .collect(Collectors.toList());
        assertEquals(manager.filtredIsActive(),filtred);
    }
}
