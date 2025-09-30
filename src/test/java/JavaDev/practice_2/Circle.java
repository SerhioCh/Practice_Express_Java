package JavaDev.practice_2;

public class Circle {
    int radius;
    Circle(int radius){
        this.radius = radius;
    }
    int getRadius(){
        return this.radius;
    }
    void setRadius(int radius){
        this.radius = radius;
    }
    double  calculateArea(double radius){
        return  Math.PI*(radius*radius);
    }

    double calculateCircumference(double  radius){
        return 2* Math.PI * radius;
}

    public static void main(String[] args) {
        Circle c1 = new Circle(25);
        System.out.println(c1.calculateArea(c1.radius));
        System.out.println(c1.calculateCircumference(c1.radius));
        c1.setRadius(40);
        System.out.println(c1.calculateArea(c1.radius));
        System.out.println(c1.calculateCircumference(c1.radius));

    }


    }
