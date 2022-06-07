package com.graphql.controller;

import com.graphql.model.Address;
import com.graphql.model.Customer;
import com.graphql.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;


@Controller
public class CustomerController {


    @Autowired
    private CustomerRepository customerRepository;

    @QueryMapping
    List<Customer> getCustomers(){
       return customerRepository.findAll();
    }

    /**
     * Get Customers by using customerId
     * @param customerId
     * @return Customer Object
     */
    @QueryMapping
    Customer  getCustomerById(@Argument Integer customerId){
      Optional<Customer> customer = customerRepository.findById(customerId);
      return customer.isPresent()?customer.get():null;
    }

    /**
     * Save Customer Object
     * @param customer
     * @return
     */
    @MutationMapping
    Customer saveCustomer(@Argument Customer customer){
        return customerRepository.save(customer);
    }

    @MutationMapping
    String deleteCustomer(@Argument Integer customerId){
       Optional<Customer> optional= customerRepository.findById(customerId);
       if(optional.isPresent()){
           customerRepository.deleteById(customerId);
           return "customer deleted successfully";
       }else{
           return  "customer is not found with id : "+customerId;
       }
    }

    @MutationMapping
    public Customer updateCustomer(@Argument Customer customer){
       Optional<Customer> optional = customerRepository.findById(customer.getCustomerId());
        if(optional.isPresent()){
            Customer customerFromDB = optional.get();
            List<Address> address = customerFromDB.getCustomerAddress();
            customerFromDB.setCustomerAddress(address);
            customerFromDB.setCustomerName(customer.getCustomerName());
            customerFromDB.setCustomerPhoneNumber(customer.getCustomerPhoneNumber());
            customerFromDB.setCustomerSignUpDate(customerFromDB.getCustomerSignUpDate());
           return customerRepository.save(customerFromDB);
        }else{
            throw  new RuntimeException("Customer not found ");
        }
    }
}
