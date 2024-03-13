package com.example.demo.controllers;

import com.example.demo.entity.Customer;
import com.example.demo.exception.DuplicateUsernameException;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.services.CustomerService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
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
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) throws DuplicateUsernameException {
//        try {
            return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.CREATED);
//        }catch (DuplicateUsernameException e){
//            return new ResponseEntity<>(HttpStatus.CONFLICT);
//        }
    }

    @ExceptionHandler(DuplicateUsernameException.class)
    public ResponseEntity<String> handleDuplicateUsernameException(){
        return new ResponseEntity<>("Email already exists", HttpStatus.CONFLICT);
    }
}
