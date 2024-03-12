package com.example.demo.services;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }


    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }
    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }
}
