package nl.blitz.cleancode.cart;

public class CartItem {
    public int productId;
    public String name;
    public double price;
    public int quantity;

    public CartItem(int productId, String name, double price, int quantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
