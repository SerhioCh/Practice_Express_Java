package JavaDevComplexTask.Task_6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskService <T extends  Number>{
    Map<T, Task<T>> taskManage = new HashMap<>();

   public   Map<T, Task<T>>  getAll(){
       return  Map.copyOf(taskManage);
   }

    public  void addTask(Task <T> tasks){
        if(taskManage.containsKey(tasks.getId())){
            throw  new IllegalArgumentException("Задача с таким ID уже существует");
        }
        taskManage.put(tasks.getId(),tasks);

    }
    public void  removeTask(T id){
        taskManage.remove(id);
    }

    public List <Task <T>> filtredByStatusAndPriority(String status, String priority){
      return   taskManage.values().stream()
                .filter(task -> task.getStatus().equals(status)&& task.getPriority().equals(priority))
                .collect(Collectors.toList());

    }
    public  List<Task<T>> sortedTaskForDate(){
        return  taskManage.values().stream()
                .sorted((e1,e2) -> e1.getDate().compareTo(e2.getDate()))
                .collect(Collectors.toList());
    }

}
