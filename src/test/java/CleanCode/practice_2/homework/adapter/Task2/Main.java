package CleanCode.practice_2.homework.adapter.Task2;

public class Main {
    public static void main(String[] args) {
        Distance distance = new MilesToKilometersAdapter(new Miles());
        System.out.println(distance.getDistance());
    }
}
