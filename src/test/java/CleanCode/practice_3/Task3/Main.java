package CleanCode.practice_3.Task3;

public class Main {
    public static void main(String[] args) {

        VirtualBook bookProxy = new BookProxy("title","author","desc");

        System.out.println("Название "+ bookProxy.getTitle());

        System.out.println(bookProxy.getContent());

        System.out.println("Название "+ bookProxy.getTitle());
    }
}
