package Task_5;

import java.util.*;
import java.util.stream.Collectors;

public class InventoryService {
    private InventoryOpen inventoryOpen;
    Map<String,List<Product>> storageProduct = new HashMap<>();

    public  InventoryService(){
        this.inventoryOpen = new InventoryOpen(true);
    }
    public  InventoryService(boolean isOpen){
        this.inventoryOpen = new InventoryOpen(isOpen);
    }

    public void   openInventory(){
        inventoryOpen.setInventoryOpen(true);
    }
    public void   closeInventory(){
        inventoryOpen.setInventoryOpen(false);
    }
    public  boolean isInventoryOpen(){
        return  inventoryOpen.isInventoryOpen();
    }

    public void addProductOnStorage(String category, Product product){
        if (!inventoryOpen.isInventoryOpen()) {
            throw  new IllegalArgumentException("Склад закрыт,добавление невозможно");
        }
        List<Product> products = storageProduct.getOrDefault(category,new ArrayList<>());
        products.add(product);
        storageProduct.put(category,products);

    }
    public  void createEmptyCategory (String category) throws OutOfStockException {
        storageProduct.putIfAbsent(category,new ArrayList<>());
        List<Product> products = storageProduct.get(category);
        if(products.isEmpty()){
            throw  new OutOfStockException("В категории закончились продукты или они не были добавлены");
        }
    }

    public  Map<String,List<Product>> getAll (){
        return  Map.copyOf(storageProduct);
    }

    public  List <Product>  getProductOfCategory(String category) throws OutOfStockException {
        if (!storageProduct.containsKey(category)) {
            throw new IllegalArgumentException("Выбранной категории не существует");
        }

        List<Product> products = storageProduct.get(category);
        if(products.isEmpty()){
            throw  new OutOfStockException("В категории закончились продукты или они не были добавлены");
        }
return  products;
    }

    public  List <Product> filtredProductByCategory (String category){
        return storageProduct.entrySet().stream()
                .filter(c -> c.getKey().equals(category))
                .flatMap(p -> p.getValue().stream())
                .collect(Collectors.toList());
    }

    public  List <Product> filtredProductByCost(double cost){
        return  storageProduct.values().stream()
                .flatMap(p -> p.stream())
                .filter(c -> c.getCost()>cost)
                .collect(Collectors.toList());
    }

}
