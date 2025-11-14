package nl.blitz.cleancode.inventory;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private String category;
    private String supplier;

    public Product(String name, double price, int quantity, String category, String supplier) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.supplier = supplier;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public String getSupplier() {
        return supplier;
    }

}
