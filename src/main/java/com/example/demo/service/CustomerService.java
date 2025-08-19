package com.example.demo.service;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final List<Customer> customers = new ArrayList<>();

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public Customer getCustomerById(Long id) {
        Optional<Customer> customer = customers.stream().filter(c -> c.getId().equals(id)).findFirst();
        return customer.orElse(null);
    }

    public Customer addCustomer(Customer customer) {
        customers.add(customer);
        return customer;
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId().equals(id)) {
                customers.set(i, updatedCustomer);
                return updatedCustomer;
            }
        }
        return null;
    }

    public boolean deleteCustomer(Long id) {
        return customers.removeIf(c -> c.getId().equals(id));
    }
}
