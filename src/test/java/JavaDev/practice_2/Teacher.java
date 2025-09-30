package JavaDev.practice_2;

public class Teacher {
    String name;
    String subject;

    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    void printInfo(){
        System.out.println("Учитель: "+ name + " Предмет: "+ subject);
    }

    public static void main(String[] args) {
        Teacher t1 = new Teacher("Anna", "Math");
        t1.printInfo();
        t1.setSubject("Eng");
        t1.printInfo();
    }
}
