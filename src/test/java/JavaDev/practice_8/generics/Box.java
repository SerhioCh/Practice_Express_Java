package JavaDev.practice_8.generics;

public class Box <T> {
    public T element;

    public  void  setElement(T element){
        this.element = element;
    }

    public  T getElement(){
       return   this.element;
    }

    Box <Book> boxWithBooks = new Box<>();

    public void setBoxWithBooks(Box<Book> boxWithBooks) {

    }
}
