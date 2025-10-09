package CleanCode.practice_2.homework.adapter.Task2;

public class MilesToKilometersAdapter implements Distance {
    Miles miles;

    public MilesToKilometersAdapter(Miles miles) {
        this.miles = miles;
    }

    @Override
    public double getDistance() {
      double coef = 1.609;
        return miles.getDistance() * coef;

    }
}
