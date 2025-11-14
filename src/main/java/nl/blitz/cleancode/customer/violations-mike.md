# violation found within this module

## lijkt me heel sterkt dat je errors wilt ignoren??

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

## methodes waar je een output verwacht hebben deze niet
    private void sendWelcomeEmail(String email) {
        // send email
    }

    private void updateCustomerRecord(int id) {
        // update record
    }

## also custom class if being created within the customerservice which is not correct, this needs to be its seperate class with all the methods related to it.


## methods were moved to the customer class instead

### this is the constructor now
    public int createCustomer(String name, String email) {
        if (name == null || name.isEmpty()) {
            return -1;
        }
        if (email == null || !email.contains("@")) {
            return -2;
        }

        int newId = customers.size() + 1;
        Customer c = new Customer(newId, name, email, true);
        return c.id;
    }
### was moved
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