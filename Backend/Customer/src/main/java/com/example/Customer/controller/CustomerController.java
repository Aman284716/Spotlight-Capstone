package com.example.Customer.controller;

import com.example.Customer.dto.CustomerDTO;
import com.example.Customer.model.Customer;
import com.example.Customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Mono<CustomerDTO> createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @GetMapping("/{id}")
    public Mono<CustomerDTO> getCustomerById(@PathVariable Integer id) {
        return customerService.getCustomerById(id);
    }

//    @GetMapping("/username/{username}")
//    public Mono<CustomerDTO> getCustomerByUsername(@PathVariable String username) {
//        return customerService.getCustomerByUsername(username);
//    }
//
//    @GetMapping("/email/{email}")
//    public Mono<CustomerDTO> getCustomerByEmail(@PathVariable String email) {
//        return customerService.getCustomerByEmail(email);
//    }

    @PutMapping("/{id}")
    public Mono<CustomerDTO> updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteCustomer(@PathVariable Integer id) {
        return customerService.deleteCustomer(id);
    }
}
