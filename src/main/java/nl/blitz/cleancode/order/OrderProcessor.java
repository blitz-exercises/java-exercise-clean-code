package nl.blitz.cleancode.order;

import java.util.List;

class OrderProcessor {
    public int processOrder(int orderId, String customerName, String customerEmail, String shippingAddress, String paymentMethod, boolean applyDiscount, boolean sendConfirmation, boolean updateInventory) {
        // validate order
        if (orderId <= 0) {
            return -1;
        }
        if (customerName == null || customerName.isEmpty()) {
            return -2;
        }
        if (customerEmail == null || !customerEmail.contains("@")) {
            return -3;
        }
        if (shippingAddress == null || shippingAddress.isEmpty()) {
            return -4;
        }
        if (paymentMethod == null) {
            return -5;
        }

        // calculate total
        double total = 0;
        List<OrderItem> items = getOrderItems(orderId);
        if (items == null) {
            return -6;
        }
        for (OrderItem item : items) {
            total += item.price * item.quantity;
        }

        // apply discount if flag is true
        if (applyDiscount) {
            total = total * 0.9;
        }

        // process payment
        int paymentResult = processPayment(paymentMethod, total);
        if (paymentResult != 0) {
            return paymentResult;
        }

        // update inventory
        if (updateInventory) {
            for (OrderItem item : items) {
                updateItemStock(item.productId, item.quantity);
            }
        }

        // send confirmation
        if (sendConfirmation) {
            sendEmail(customerEmail, "Order confirmed");
        }

        // update order status
        updateOrderStatus(orderId, "PROCESSED");

        return 0;
    }

    private List<OrderItem> getOrderItems(int orderId) {
        // database call
        return null;
    }

    private int processPayment(String method, double amount) {
        // payment processing
        return 0;
    }

    private void updateItemStock(int productId, int quantity) {
        // inventory update
    }

    private void sendEmail(String email, String message) {
        // email sending
    }

    private void updateOrderStatus(int orderId, String status) {
        // status update
    }

    class OrderItem {
        int productId;
        double price;
        int quantity;
    }
}

