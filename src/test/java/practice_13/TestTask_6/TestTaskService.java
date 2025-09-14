package practice_13.TestTask_6;

import Task_6.Task;
import Task_6.TaskService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

public class TestTaskService {
    @Test
    public  void checkAddTask(){
        TaskService <Integer> taskService= new TaskService<>();
        Task <Integer> expectedTask = new Task<>(1,"InWork","High", LocalDate.now());
        taskService.addTask(expectedTask);
        assertFalse(taskService.getAll().isEmpty());
        assertEquals(taskService.getAll().get(1),expectedTask);
    }

    @Test
    public  void checkExceptionAddTask(){
        TaskService <Integer> taskService= new TaskService<>();
        Task <Integer> expectedTask = new Task<>(1,"InWork","High", LocalDate.now());
        taskService.addTask(expectedTask);
        Exception exception = assertThrows(IllegalArgumentException.class,() ->{
            taskService.addTask( new Task<>(1,"InWork","High", LocalDate.now()));
        });
        assertEquals("Задача с таким ID уже существует",exception.getMessage());
    }

  @Test
    public  void checkFilterTaskStatusAndPriority(){
      TaskService <Integer> taskService= new TaskService<>();
      taskService.addTask( new Task<>(1,"InWork","Medium", LocalDate.now()));
      taskService.addTask( new Task<>(2,"New","Low", LocalDate.now()));
      taskService.addTask( new Task<>(3,"Done","High", LocalDate.now()));
      taskService.addTask( new Task<>(4,"InWork","High", LocalDate.now()));
      taskService.addTask( new Task<>(5,"ReWork","High", LocalDate.now()));

      assertTrue(taskService.filtredByStatusAndPriority("InWork","High").stream().allMatch(t->t.getStatus().equals("InWork") && t.getPriority().equals("High")));
  }

    @Test
    public  void checkSortedTaskForDate(){
        TaskService <Integer> taskService= new TaskService<>();
        taskService.addTask( new Task<>(1,"InWork","Medium", LocalDate.of(2025, Month.MAY,12)));
        taskService.addTask( new Task<>(2,"New","Low", LocalDate.of(2025, Month.DECEMBER,24)));
        taskService.addTask( new Task<>(3,"Done","High", LocalDate.of(2025, Month.OCTOBER,15)));
        taskService.addTask( new Task<>(4,"InWork","High", LocalDate.of(2024, Month.FEBRUARY,11)));
        taskService.addTask( new Task<>(5,"ReWork","High", LocalDate.of(2023, Month.MAY,13)));

        assertEquals(taskService.sortedTaskForDate().stream().findFirst().get().getDate(),taskService.getAll().get(5).getDate());
    }
}
