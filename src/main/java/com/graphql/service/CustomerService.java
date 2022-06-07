package com.graphql.service;

import com.graphql.model.Customer;

import java.util.List;

public interface CustomerService {
    public Customer saveCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
    public Customer getCustomerById(Integer customerId);
    public List<Customer> getAllCustomers();
    public String deleteCustomer(Integer customerId);
}
