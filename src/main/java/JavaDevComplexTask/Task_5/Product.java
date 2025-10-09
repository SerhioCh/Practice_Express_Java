package JavaDevComplexTask.Task_5;

import java.util.Objects;

public class Product {
    private  String name;
    private  double cost;
    private  String category;

    public Product(String name, double cost, String category) {
        this.name = name;
        this.cost = cost;
        this.category = category;
    }

    public Product(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.cost, cost) == 0 && Objects.equals(name, product.name) && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost, category);
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Наименование='" + name + '\'' +
                ", Цена=" + cost +
                ", Категория='" + category + '\'' +
                '}';
    }
}
