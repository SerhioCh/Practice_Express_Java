package JavaDev.practice_6.HomeWork.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class TaskOfLinkedHashMap {
    LinkedHashMap <Integer,String> person = new LinkedHashMap<>();

    public  void printPerson () {
        for (Map.Entry<Integer,String> entry: person.entrySet()){
            System.out.println("Телефон пользователя : "+ entry.getKey() + " Имя пользователя:"+entry.getValue());
        }
    }

    public void getContactInPhone(String name){
      boolean found = false;
        for (Map.Entry<Integer,String> entry : person.entrySet()){
          if (entry.getValue().equals(name)){
              System.out.println("Контакт: "+ entry.getKey() + " Имя: " + entry.getValue());
              found = true;
              break;
          }
        }
        if (!found){
            System.out.println("Контакт не найден");
      }
    }

    public static void main(String[] args) {
        TaskOfLinkedHashMap task = new TaskOfLinkedHashMap();
        task.person.put(154353,"Serega");
        task.person.put(121414217,"Vasya");
        task.person.put(1242146,"Petya");
        task.person.put(5327765,"Masha");
        task.person.put(43631,"Dmitri");
     //   task.printPerson(); //Задача вывести значения в порядке добавления
       // task.getContactInPhone("Mixa"); Задача 3
    }
}
