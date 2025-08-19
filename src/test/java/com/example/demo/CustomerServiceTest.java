package com.example.demo;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerServiceTest {

    private CustomerService customerService;

    @BeforeEach
    public void setup() {
        customerService = new CustomerService();
    }

    @Test
    public void testAddCustomer() {
        Customer customer = new Customer(1L, "John Doe", "1234567890", 500.0);
        customerService.addCustomer(customer);
        assertEquals(1, customerService.getAllCustomers().size());
    }

    @Test
    public void testGetCustomerById() {
        Customer customer = new Customer(1L, "John Doe", "1234567890", 500.0);
        customerService.addCustomer(customer);
        Customer found = customerService.getCustomerById(1L);
        assertNotNull(found);
        assertEquals("John Doe", found.getName());
    }

    @Test
    public void testUpdateCustomer() {
        Customer customer = new Customer(1L, "John Doe", "1234567890", 500.0);
        customerService.addCustomer(customer);
        Customer updated = new Customer(1L, "Jane Doe", "9876543210", 600.0);
        customerService.updateCustomer(1L, updated);
        Customer found = customerService.getCustomerById(1L);
        assertEquals("Jane Doe", found.getName());
    }

    @Test
    public void testDeleteCustomer() {
        Customer customer = new Customer(1L, "John Doe", "1234567890", 500.0);
        customerService.addCustomer(customer);
        assertTrue(customerService.deleteCustomer(1L));
        assertEquals(0, customerService.getAllCustomers().size());
    }
}
