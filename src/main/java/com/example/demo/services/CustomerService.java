package com.example.demo.services;

import com.example.demo.config.JwtUtils;
import com.example.demo.entity.Customer;
import com.example.demo.exception.DuplicateUsernameException;
import com.example.demo.repository.CustomerRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private JwtUtils jwtUtils;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
        this.jwtUtils = new JwtUtils();
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

    public Customer getCustomer(Long id){
        return customerRepository.findById(id).get();
    }

    public String login(Customer customer){
        if (customer == null) {
            return null;
        }
        Customer found = customerRepository.findByUsername(customer.getUsername()).get(0);
        if (!found.getPassword().equals(customer.getPassword())) {
            return null;
        }
        String token = jwtUtils.generateToken(found.getId());
        return token;
    }
}
