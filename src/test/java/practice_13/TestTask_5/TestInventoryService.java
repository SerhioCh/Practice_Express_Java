package practice_13.TestTask_5;

import Task_5.InventoryService;
import Task_5.OutOfStockException;
import Task_5.Product;
import org.junit.jupiter.api.Test;
import practice_5.task_2.Electronics;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestInventoryService {

    @Test
    public  void checkAddProduct(){
        InventoryService service = new InventoryService();
        Product  expectedProduct = new Product("Iphone",200.5,"Electronics");
        service.addProductOnStorage("Electronics",expectedProduct);
        assertFalse(service.getAll().isEmpty());
        assertEquals(service.getAll().values().stream()
                        .findFirst().get().get(0).getName()
                ,expectedProduct.getName());
    }
    @Test
    public  void checkExceptionAddProduct(){
        InventoryService service = new InventoryService();
        service.closeInventory();
        Product  expectedProduct = new Product("Iphone",200.5,"Electronics");

        Exception exception = assertThrows(IllegalArgumentException.class,()-> {
            service.addProductOnStorage("Electronics",expectedProduct);
        });

        assertEquals("Склад закрыт,добавление невозможно",exception.getMessage());
    }

    @Test
    public  void checkProductsCategoryIsEmpty() {
        InventoryService service = new InventoryService();
        Product expectedProduct = new Product("Iphone", 200.5, "Electronics");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.getProductOfCategory("One");
        });

        assertEquals("Выбранной категории не существует", exception.getMessage());
    }

    @Test
    public  void checkProductsIsEmptyOfCategory() {
        InventoryService service = new InventoryService();
        Exception exception = assertThrows(OutOfStockException.class, () -> {
            service.createEmptyCategory("Electronics");
            service.getProductOfCategory("Electronics");
        });

        assertEquals("В категории закончились продукты или они не были добавлены", exception.getMessage());
    }

    @Test
    public  void checkFilterProductsOfCategory() {
        InventoryService service = new InventoryService();
        service.addProductOnStorage("Electronics",new Product("Iphone",200.5,"Electronics"));
        service.addProductOnStorage("Electronics",new Product("Iphone",200.5,"Electronics"));
        service.addProductOnStorage("Electronics",new Product("Samsung",79.5,"Electronics"));
        service.addProductOnStorage("Electronics",new Product("Samsung",79.5,"Electronics"));
        service.addProductOnStorage("Electronics",new Product("Iphone",200.5,"Electronics"));
        service.addProductOnStorage("Kitchen",new Product("Spoon",11.25,"Kitchen"));
        service.addProductOnStorage("Kitchen",new Product("Fork",200.5,"Kitchen"));

        assertTrue(service.filtredProductByCategory("Electronics").stream().allMatch(p -> p.getCategory().equals("Electronics")));
    }

    @Test
    public  void checkFilterProductsByCost() {
        InventoryService service = new InventoryService();
        service.addProductOnStorage("Electronics",new Product("Iphone",200.5,"Electronics"));
        service.addProductOnStorage("Electronics",new Product("Iphone",200.5,"Electronics"));
        service.addProductOnStorage("Electronics",new Product("Samsung",79.5,"Electronics"));
        service.addProductOnStorage("Electronics",new Product("Samsung",79.5,"Electronics"));
        service.addProductOnStorage("Electronics",new Product("Iphone",200.5,"Electronics"));
        service.addProductOnStorage("Kitchen",new Product("Spoon",11.25,"Kitchen"));
        service.addProductOnStorage("Kitchen",new Product("Fork",200.5,"Kitchen"));

        assertTrue(service.filtredProductByCost(150).stream().allMatch(c -> c.getCost()>150));
    }


}
