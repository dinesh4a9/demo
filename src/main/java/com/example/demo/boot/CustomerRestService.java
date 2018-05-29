package com.example.demo.boot;

import com.example.demo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class CustomerRestService {

    CustomerService customerService;

    public CustomerRestService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public Collection<Customer> readAll(){
       return this.customerService.findAll();
    }
}
