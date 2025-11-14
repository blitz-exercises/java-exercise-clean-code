package nl.blitz.cleancode.customer;

import java.util.HashMap;
import java.util.Map;

class CustomerService {
    private Map<Integer, Customer> customers = new HashMap<>();

    public Customer getCustomer(int id) {
        Customer c = customers.get(id);
        if (c == null) {
            return null;
        }
        if (!c.active) {
            return null;
        }
        return c;
    }

    public int createCustomer(String name, String email) {
        if (name == null || name.isEmpty()) {
            return -1;
        }
        if (email == null || !email.contains("@")) {
            return -2;
        }

        Customer c = new Customer();
        c.id = customers.size() + 1;
        c.name = name;
        c.email = email;
        c.active = true;
        customers.put(c.id, c);
        return c.id;
    }

    public int updateCustomer(int id, String name, String email) {
        Customer c = customers.get(id);
        if (c == null) {
            return -1;
        }
        if (name != null) {
            c.name = name;
        }
        if (email != null) {
            c.email = email;
        }
        return 0;
    }

    public void deleteCustomer(int id) {
        Customer c = customers.get(id);
        if (c != null) {
            c.active = false;
        }
    }

    public void processAllCustomers() {
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

    private void validateCustomer(Customer c) throws Exception {
        if (c == null) {
            throw new Exception("Invalid customer");
        }
    }

    private void sendWelcomeEmail(String email) {
        // send email
    }

    private void updateCustomerRecord(int id) {
        // update record
    }

    class Customer {
        public int id;
        public String name;
        public String email;
        public boolean active;
    }
}

