package nl.blitz.cleancode.order;

import java.util.List;
import nl.blitz.cleancode.email.EmailService;
import nl.blitz.cleancode.shipping.ShippingService;

class OrderService {
    private OrderRepository orderRepo = new OrderRepository();
    private PaymentService paymentService = new PaymentService();
    private InventoryService inventoryService = new InventoryService();
    private EmailService emailService = new EmailService();
    private ShippingService shippingService = new ShippingService();
    private ReportService reportService = new ReportService();

    public int createOrder(int customerId, List<Integer> productIds) {
        Order order = new Order();
        order.customerId = customerId;
        order.productIds = productIds;
        order.status = "PENDING";
        
        int orderId = orderRepo.save(order);
        
        double total = calculateTotal(productIds);
        order.total = total;
        
        int paymentResult = paymentService.processPayment(customerId, total);
        if (paymentResult != 0) {
            order.status = "PAYMENT_FAILED";
            orderRepo.update(order);
            return -1;
        }
        
        inventoryService.reserveItems(productIds);
        
        emailService.send("customer@example.com", "Order Confirmed", "Your order has been confirmed");
        
        shippingService.createShipment(orderId);
        
        reportService.logOrder(orderId);
        
        order.status = "CONFIRMED";
        orderRepo.update(order);
        
        return orderId;
    }

    private double calculateTotal(List<Integer> productIds) {
        double total = 0;
        for (Integer productId : productIds) {
            total += inventoryService.getPrice(productId);
        }
        return total;
    }

    class Order {
        int id;
        int customerId;
        List<Integer> productIds;
        double total;
        String status;
    }
}

class OrderRepository {
    public int save(OrderService.Order order) {
        return 1;
    }

    public void update(OrderService.Order order) {
    }
}

class PaymentService {
    public int processPayment(int customerId, double amount) {
        return 0;
    }
}

class InventoryService {
    public void reserveItems(List<Integer> productIds) {
    }

    public double getPrice(int productId) {
        return 10.0;
    }
}

class ReportService {
    public void logOrder(int orderId) {
    }
}

