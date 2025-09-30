package JavaDev.practice_8.liblary;

import JavaDev.practice_8.liblary.exceptions.BookNoyFoundException;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("1994","Oryel"));
        library.addBook(new Book("1545","Puskin"));
  //      library.addBook(new Book("1994","Oryel"));
        try {
            library.findBook("344");
        } catch (BookNoyFoundException e) {
            System.out.println("Поймали исключение");
        }

    }
}
