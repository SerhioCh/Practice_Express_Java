package practice_2;

public class Point {
    int x;
    int y;
    Point(int x , int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    void print(){
        System.out.println("Координата х: "+ x);
        System.out.println("Координата y: "+ y);
    }

    public static void main(String[] args) {
        Point p1 = new Point(3,4);
        p1.print();
        p1.setX(10);
        p1.print();
    }
}
