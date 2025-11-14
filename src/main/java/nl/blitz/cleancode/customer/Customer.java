package nl.blitz.cleancode.customer;

import java.util.Map;

public class Customer {
    public int id;
    public String name;
    public String email;
    public boolean active;

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.active = true;
    }

    public String sendWelcomeEmail(String email) {
        return "Welkom bij ons hippe evenement;";
    }

    public void validateCustomer(Customer c) throws Exception {
        if (c == null) {
            throw new Exception("Invalid customer");
        }
    }

    public String updateCustomerRecord(int id) {
        return "Customer record was updated";
    }

    public void processAllCustomers(Map<Integer, Customer> customers) {
        for (Customer c : customers.values()) {
            try {
                validateCustomer(c);
                sendWelcomeEmail(c.email);
                updateCustomerRecord(c.id);
            } catch (Exception e) {
                // ignore errors
            }
        }
    }

    public String updateCustomer(Customer customer, String name, String email) {
        if (name != null) {
            customer.name = name;
        }
        if (email != null) {
            customer.email = email;
        }
        return "Customer was updated";
    }

    public Customer getCustomer() {
        if (!this.active) {
            return null;
        } else {
            return this;
        }
    }

    public void deleteCustomer(

    ) {
        if (this != null) {
            this.active = false;
        }
    }
}
