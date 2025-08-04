package practice_6.HomeWork.HashMap;

import java.util.HashMap;
import java.util.Map;

public class TaskOfHashMap {

    HashMap <String,Integer> person = new HashMap<>();

    public void checkNameInMap (String name) {
     boolean b =   person.containsKey(name);
        System.out.println(b);
    }

    public  void printChildren (){
        for (Map.Entry<String,Integer> entry: person.entrySet()){
           int age = entry.getValue();
            if (age<18) {
                System.out.println("Имя: "+ entry.getKey() + " возраст: "+ entry.getValue());
            }
        }
    }


    public static void main(String[] args) {
        TaskOfHashMap task = new TaskOfHashMap();
        task.person.put("Serega",25);
        task.person.put("Vasya",21);
        task.person.put("Petya",27);
        task.person.put("Lev",17);
        task.person.put("Sasha",12);
        //System.out.println(task.person); // Задача 1 добавить 5 записей и вывести их
        //task.checkNameInMap("Mixa"); // Задача 2 метод по проверки имени в HashMap
        //task.printChildren(); // Задача 3 вывести пользователей младше 18 лет

    }
}
