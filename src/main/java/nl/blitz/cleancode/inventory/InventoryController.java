package nl.blitz.cleancode.inventory;

import java.util.ArrayList;
import java.util.List;

class InventoryController {
    // im treating this list as the DB, so when i consider things i assume this list is the area
    // where all the product are stored.
    // hence some methods arent moved since they call the DB
    private List<Product> products = new ArrayList<>();

    public void addProduct(String name, double price, int quantity, String category,
            String supplier) {
        Product prod = new Product(name, price, quantity, category, supplier);
        products.add(prod);
    }

    public Product findProduct(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public void updateStock(String productName, int newQuantity) {
        Product product = findProduct(productName);
        if (product != null) {
            product.setQuantity(newQuantity);
        }
    }

    public List<Product> getLowStockItems() {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getQuantity() < 10) {
                result.add(product);
            }
        }
        return result;
    }

    public void processInventory() {
        for (Product product : products) {
            if (product.getQuantity() < 5) {
                System.out.println("Low stock: " + product.getName());
            }
            if (product.getPrice() > 100) {
                System.out.println("Expensive item: " + product.getName());
            }
            if (product.getCategory().equals("ELECTRONICS")) {
                System.out.println("Electronics item: " + product.getName());
            }
        }
    }


}

