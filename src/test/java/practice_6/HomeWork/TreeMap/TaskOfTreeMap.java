package practice_6.HomeWork.TreeMap;

import java.util.TreeMap;

public class TaskOfTreeMap {
    TreeMap <Integer,String> person = new TreeMap<>();

   public  void minMaxKeyInMap(){
       Integer minKey = person.firstKey();
       System.out.println("Выведен минимальный ключ: "+minKey);

       Integer maxKey = person.lastKey();
       System.out.println("Выведен максимальный  ключ: "+maxKey);
   }
   public  void searchMaxKey (int key){
       if (person.higherKey(key)==null){
           System.out.println("Выше значения нет");
       }
       System.out.println(person.higherKey(key));


   }


    public static void main(String[] args) {

        TaskOfTreeMap task = new TaskOfTreeMap();
        task.person.put(17,"Serega");
        task.person.put(89,"Valya");
        task.person.put(16,"Petya");
        task.person.put(36,"Masha");
        task.person.put(54,"Vlad");
       // System.out.println(task.person); // Задача 1  Значения изначально выведены в отсортированном порядке
       // task.minMaxKeyInMap(); // Задача 2 найдены минимальные и максимальные ключи , так как коллекция уже отсортирована мы можем брать первое и последне значение
      //  task.searchMaxKey(100); // Задача 3  поиск ближайшего большего значения от заданного
    }
}
