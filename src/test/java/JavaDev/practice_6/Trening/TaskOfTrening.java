package JavaDev.practice_6.Trening;

import java.util.HashMap;
import java.util.Map;

public class TaskOfTrening {
    HashMap <Integer,String> person = new HashMap<>();

public void  checkNumberOfName (String name){
    for (Map.Entry<Integer,String> s : person.entrySet()){
        if(s.getValue().equals(name)){
            System.out.println("Номер: "+ s.getKey());
        }

    }
}


    public static void main(String[] args) {
        TaskOfTrening task = new TaskOfTrening();
        task.person.put(124124,"Serega");
        task.person.put(643521,"Vasya");
        task.person.put(7564546,"Petya");
        task.person.put(87685,"Nikita");
        task.checkNumberOfName("Vasya");
    }
}
