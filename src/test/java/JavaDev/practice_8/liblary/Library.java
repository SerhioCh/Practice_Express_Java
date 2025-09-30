package JavaDev.practice_8.liblary;

import JavaDev.practice_8.liblary.exceptions.BookNoyFoundException;
import JavaDev.practice_8.liblary.exceptions.InvalidBookException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Library {
    private List<Book> books;
    public Library(){
        this.books = new ArrayList<>();
    }

    public  void addBook(Book book) throws InvalidBookException{
        if (books.contains(book)){
            throw  new InvalidBookException("Такая книга уже существует в библиотеке!");
        }
        else {
            books.add(book);
        }
    }

    public Book findBook(String name) throws BookNoyFoundException{
        AtomicReference <Book> foundBook = new AtomicReference<>();
        books.forEach(book -> {
            if (book.getName() == name){
                foundBook.set(book);
            }
        });
        if (foundBook.get()==null){
            throw new  BookNoyFoundException("Не нашли книгу по имени "+ name);
        }
        return foundBook.get();
    }

}
