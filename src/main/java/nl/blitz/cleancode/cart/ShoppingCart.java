package nl.blitz.cleancode.cart;

import java.util.ArrayList;
import java.util.List;

class ShoppingCart {
    public List<CartItem> items;
    public double total;
    public String customerId;
    public boolean isCheckedOut;

    public ShoppingCart() {
        items = new ArrayList<>();
        total = 0.0;
        isCheckedOut = false;
    }

    public void addItem(int productId, String name, double price, int quantity) {
        CartItem item = new CartItem();
        item.productId = productId;
        item.name = name;
        item.price = price;
        item.quantity = quantity;
        items.add(item);
        total += price * quantity;
    }

    public void removeItem(int productId) {
        for (CartItem item : items) {
            if (item.productId == productId) {
                total -= item.price * item.quantity;
                items.remove(item);
                break;
            }
        }
    }

    public void updateQuantity(int productId, int newQuantity) {
        for (CartItem item : items) {
            if (item.productId == productId) {
                total -= item.price * item.quantity;
                item.quantity = newQuantity;
                total += item.price * item.quantity;
                break;
            }
        }
    }

    public double calculateTotal() {
        double sum = 0;
        for (CartItem item : items) {
            sum += item.price * item.quantity;
        }
        return sum;
    }

    class CartItem {
        public int productId;
        public String name;
        public double price;
        public int quantity;
    }
}

