package nl.blitz.cleancode.customer;

import java.util.HashMap;
import java.util.Map;

class CustomerService {
    // Niet 100% zeker of dit hier wel of niet hoort aangezien je mogelijk niet je lijst van
    // gebruikers in de customerservice wilt hebben
    // maar je wilt dit ook niet in je customer class hebben dus voor nu is het hier prima normaal
    // zou dit vanuit een DB komen
    private Map<Integer, Customer> customers = new HashMap<>();

    // implementation to use the functions from customer to act as a customerserice


    // Seems that implementations here arent needed since the CustomerService merely calls to the
    // functions of the customer in order to get data,
    // so im not sure exactly what i should implement in customerservice atm

    // public Customer createCustomer(String name, String email) {
    // Customer customer = new Customer(customers.size() + 1, name, email);
    // customer.sendWelcomeEmail(email);
    // return customer;
    // }

    // public String updateCustomer(Customer customer, String name, String email) {
    // if (name != null) {
    // customer.name = name;
    // }
    // if (email != null) {
    // customer.email = email;
    // }
    // return "Customer was updated";
    // }

    // public void deleteCustomer(Customer customer) {
    // customer.deleteCustomer();
    // }
}
