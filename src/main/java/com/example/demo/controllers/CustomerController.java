package com.example.demo.controllers;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }
    @GetMapping
    public List<Customer> index(){
        System.out.println("Find all customers");
        return customerService.getCustomers();
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
        System.out.println("Create customer" + customer);
        return customerService.createCustomer(customer);
    }

}
