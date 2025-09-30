package JavaDev.practice_6.contact_book;

public class Main {
    public static void main(String[] args) {
        ContactBook contactBook = new ContactBook();
        contactBook.addContact("Никита",1235);
        contactBook.addContact("Коля",52342);
        contactBook.addContact("Вася",654654);

        contactBook.printContacts();
        contactBook.updatePhone("Коля",67777);
        contactBook.printContacts();
    }
}
