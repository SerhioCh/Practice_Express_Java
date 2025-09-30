package JavaDev.practice_8.HomeWork.generics;

public class Box <T> {
    T element;
    public  void  setElement (T element){
        this.element= element;
    }
    public  T getElement(){
        return this.element;
    }

    public  <T> void printArray (T[] array){
        for (T item: array){
            System.out.println(item);
        }
    }
}
