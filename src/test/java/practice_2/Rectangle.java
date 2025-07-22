package practice_2;

public class Rectangle {
    int width;
    int height;
    Rectangle(int width,int height){
        this.height = height;
        this.width = width;
    }
    int getWidth (){
        return  this.width;
    }
    int getHeight(){
        return  this.height;
    }

    void setWidth (int width){
        this.width = width;
    }

    int calculateArea(int a,int b){
        return  a*b;
    }

    public static void main(String[] args) {
        Rectangle rec1 = new Rectangle(5,5);
        System.out.println(rec1.calculateArea(rec1.width,rec1.height));
        rec1.setWidth(10);
        System.out.println(rec1.calculateArea(rec1.width,rec1.height));

    }
}
