package com.graphql.serviceimpl;

import com.graphql.constants.CommonConstants;
import com.graphql.exceptions.CustomerException;
import com.graphql.model.Address;
import com.graphql.model.Customer;
import com.graphql.repository.CustomerRepository;
import com.graphql.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer customerFromDB = customerRepository.findById(customer.getCustomerId()).orElseThrow(() -> new CustomerException(CommonConstants.CUSTOMER_NOT_FOUND_MSG, CommonConstants.CUSTOMER_NOT_FOUND_ERRORCODE));
        List<Address> address = customerFromDB.getCustomerAddress();
        customerFromDB.setCustomerAddress(address);
        customerFromDB.setCustomerName(customer.getCustomerName());
        customerFromDB.setCustomerPhoneNumber(customer.getCustomerPhoneNumber());
        customerFromDB.setCustomerSignUpDate(customerFromDB.getCustomerSignUpDate());
        return customerRepository.save(customerFromDB);
    }

    @Override
    public Customer getCustomerById(Integer customerId) {
        return customerRepository.findById(customerId).orElseThrow(() -> new CustomerException(CommonConstants.CUSTOMER_NOT_FOUND_MSG, CommonConstants.CUSTOMER_NOT_FOUND_ERRORCODE));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public String deleteCustomer(Integer customerId) {
        customerRepository.findById(customerId).orElseThrow(() -> new CustomerException(CommonConstants.CUSTOMER_NOT_FOUND_MSG, CommonConstants.CUSTOMER_NOT_FOUND_ERRORCODE));
        customerRepository.deleteById(customerId);
        return "Customer Deleted Successfully!";
    }
}
