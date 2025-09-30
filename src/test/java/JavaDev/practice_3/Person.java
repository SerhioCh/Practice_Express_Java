package JavaDev.practice_3;

public class Person {
    private String firstName;
    private String lastName;
    private final String ssn;

    public Person(String firstName, String lastName, String ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    void printPersonInfo (){
        System.out.println("Имя: " + firstName  + " Фамилия:" + lastName + " SSN: "+ ssn );

    }

    public static void main(String[] args) {
        Person p1 = new Person("Serega","Pushkin","23-45-6789");
        p1.printPersonInfo();
        Person p2 = new Person("Vova","Pushkin","123-45-6789");
        p2.printPersonInfo();
        p1.setFirstName("Nikita");
        p1.printPersonInfo();
        p2.printPersonInfo();

    }
}
