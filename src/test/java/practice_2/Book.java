package practice_2;

public class Book {
    String title;
    String author;
    Book(String title,String author){
        this.author = author;
        this.title = title;
    }
    String getTitle(){
        return  this.title;
    }
    String getAuthor(){
        return  this.author;
    }
    void setTitle(String title){
        this.title= title;
    }
    void setAuthor(String author){
        this.author = author;
    }
    void printInfo(){
        System.out.println("Название книги:"+ title);
        System.out.println("Автор книги книги:"+ author);
    }

    public static void main(String[] args) {
        Book b1 = new Book("Java","Gosling");
        b1.printInfo();
        b1.setAuthor("Pushkin");
        b1.printInfo();
    }
}
