package JavaDev.practice_7;

public class Person {
    private String name;
    private Integer age;
    public  Person (String name,Integer age){
        this.name = name;
        this.age = age;
    }

    public  String toString(){
        return  "Name: "+ this.name+ ", age: "+ this.age;
    }

    public  boolean equals(Object obj){
        if (this == obj) return  true;
        if (obj == null || getClass() != obj.getClass()) return  false;
        Person that  = (Person) obj;
        if (this.name.equals(that.name) && this.age == that.age){
            return  true;}
        else {
            return  false;
        }
    }

    public  int hashCode(){
        int result = name != null ? name.hashCode() :0;
        return  result * 31 + age;
    }

    public  Person clone (){
        return  new Person(this.name,this.age);
    }




    public static void main(String[] args) {
        Person nikita = new Person("Никита",25);
        //
     //   System.out.println(nikita.toString());

        // Сравнение двух Person
        Person nikita2 = new Person("Никита",25);
        System.out.println(nikita.equals(nikita2));


        // Клонирование

        Person cloneNikita = nikita.clone();
        System.out.println(cloneNikita.toString());

    }
}
