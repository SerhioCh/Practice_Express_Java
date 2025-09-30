package JavaDev.practice_5.Restaurant;

public class Menu {
    Dish dish;

    public Menu addDish(Dish dish) {
        this.dish = dish;
        return this;
    }

    void printMenu(){
        dish.getDescription();
    }


}
