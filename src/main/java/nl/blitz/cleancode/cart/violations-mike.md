# Violations found within this module

## made the class cartItem have its own file. wasn't 100% sure how I felt about the name CartItem, could be product if its about the actual products but if its referencing to a item within a shopping cart than CartItem is acceptable i suppose.


## updated method to support the new CartItem class.
    public void addItem(int productId, String name, double price, int quantity) {
        CartItem item = new CartItem(productId, name, price, quantity);
        items.add(item);
        total += price * quantity;
    }
