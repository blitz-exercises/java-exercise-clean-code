package nl.blitz.cleancode.product;

import java.util.HashMap;
import java.util.Map;

class ProductCatalog {
    private Map<String, Product> products = new HashMap<>();

    public void addProduct(String id, String name, double price, String category) {
        Product p = new Product();
        p.id = id;
        p.name = name;
        p.price = price;
        p.category = category;
        p.inStock = true;
        products.put(id, p);
    }

    public Product getProduct(String id) {
        return products.get(id);
    }

    public void updatePrice(String id, double newPrice) {
        Product p = products.get(id);
        if (p != null) {
            p.price = newPrice;
        }
    }

    public void setInStock(String id, boolean inStock) {
        Product p = products.get(id);
        if (p != null) {
            p.inStock = inStock;
        }
    }

    public Map<String, Product> getAllProducts() {
        return products;
    }

    public void modifyProduct(String id, String name, double price, String category, boolean inStock) {
        Product p = products.get(id);
        if (p != null) {
            p.name = name;
            p.price = price;
            p.category = category;
            p.inStock = inStock;
        }
    }

    class Product {
        public String id;
        public String name;
        public double price;
        public String category;
        public boolean inStock;
    }
}

