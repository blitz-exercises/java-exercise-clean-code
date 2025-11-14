package nl.blitz.cleancode.shipping;

public class ShippingService {
    public double calculateShippingCost(double weight, String destination, String shippingMethod) {
        double cost = 0;
        if (shippingMethod.equals("STANDARD")) {
            if (weight <= 1) {
                cost = 5.0;
            } else if (weight <= 5) {
                cost = 10.0;
            } else if (weight <= 10) {
                cost = 15.0;
            } else {
                cost = 20.0;
            }
        } else if (shippingMethod.equals("EXPRESS")) {
            if (weight <= 1) {
                cost = 10.0;
            } else if (weight <= 5) {
                cost = 20.0;
            } else if (weight <= 10) {
                cost = 30.0;
            } else {
                cost = 40.0;
            }
        } else if (shippingMethod.equals("OVERNIGHT")) {
            if (weight <= 1) {
                cost = 25.0;
            } else if (weight <= 5) {
                cost = 50.0;
            } else if (weight <= 10) {
                cost = 75.0;
            } else {
                cost = 100.0;
            }
        }
        if (destination.equals("INTERNATIONAL")) {
            cost = cost * 2;
        }
        return cost;
    }

    public String getShippingStatus(int orderId) {
        // database query
        return "IN_TRANSIT";
    }

    public void updateShippingStatus(int orderId, String status) {
        // database update
    }

    public void printShippingLabel(int orderId) {
        // print label
    }

    public void createShipment(int orderId) {
        // create shipment
    }
}

