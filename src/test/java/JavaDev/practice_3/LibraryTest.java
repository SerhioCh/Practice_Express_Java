package JavaDev.practice_3;

public class LibraryTest {
    public static void main(String[] args) {
        Library l1 = new Library();
        String a =   l1.author;
        String c = l1.category;
        int y = l1.year;
        // bookTitle не можем вызвать так как он имеет модификатор доступа private
    }
}
