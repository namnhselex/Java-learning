package com.example.demo.services;

import com.example.demo.entity.Customer;
import com.example.demo.exception.DuplicateUsernameException;
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
    public Customer createCustomer(Customer customer) throws DuplicateUsernameException {
        List<Customer> found = customerRepository.findByUsername(customer.getUsername());
        if (found.size() > 0) {
            throw new DuplicateUsernameException("Email " + customer.getUsername() + " already exists");
        }
        return customerRepository.save(customer);
    }
}
