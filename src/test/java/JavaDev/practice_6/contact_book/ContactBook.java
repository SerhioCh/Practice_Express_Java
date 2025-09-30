package JavaDev.practice_6.contact_book;

import java.util.HashMap;

public class ContactBook {

    private HashMap<String,Integer> contacks;
    public  ContactBook (){
        this.contacks = new HashMap<>();
    }

    // ключ- значение (имя-телефон) (добавить контакт)
    public  void addContact (String name, Integer phone){
        contacks.put(name,phone);
    }
    // поиск контактов по имени
    public  Integer getPhone (String name){
        return  contacks.get(name);
    }
    // обновления телефона по имени
    public  void updatePhone (String name, Integer updatedPhone){
        contacks.put(name,updatedPhone);
    }
    public  void printContacts (){
        System.out.println("Все контакты");
        contacks.forEach(
                (name,phone) -> {
                    System.out.println("Имя "+ name + " ,телефон "+ phone);
                }
        );
        System.out.println();
    }
}
