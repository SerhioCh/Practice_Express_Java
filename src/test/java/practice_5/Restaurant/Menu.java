package practice_5.Restaurant;

public class Menu {
    Dish dish;

    public void addDish(Dish dish) {
        this.dish = dish;
    }

    void printMenu(){
        dish.getDescription();
    }


}
