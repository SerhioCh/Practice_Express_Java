package JavaDevComplexTask.Task_4;

public class Movie {
    private  String name;
    private boolean isPopular;

    public Movie(String name, boolean isPopular) {
        this.name = name;
        this.isPopular = isPopular;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPopular() {
        return isPopular;
    }

    public void setPopular(boolean popular) {
        isPopular = popular;
    }
}
