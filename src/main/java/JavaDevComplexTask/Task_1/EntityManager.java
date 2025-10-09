package JavaDevComplexTask.Task_1;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class EntityManager<T extends Entity> {
    CopyOnWriteArrayList <T> collection = new CopyOnWriteArrayList<>();

    public void addEntity(T entity){
        collection.add(entity);
    }

    public boolean removeEntity (T entity){
        return collection.remove(entity);
    }

    public  List <T> getAllEntity(){
        return List.copyOf(collection);
    }

    public List <T> filtredByAge (int minAge, int maxAge){
        return  collection.stream()
                .filter(age -> age.getAge() >= minAge && age.getAge() <= maxAge)
                .collect(Collectors.toList());
    }
    public List <T> filtredByName (String name){
        return  collection.stream()
                .filter(n -> n.getName().equals(name))
                .collect(Collectors.toList());
    }
    public List <T> filtredIsActive(){
        return  collection.stream()
                .filter(n -> n.isActive())  //Ищем только по true
                .collect(Collectors.toList());
    }


}
