package com.ecommerce.web.controller.customer;

import com.ecommerce.data.model.Customer;
import com.ecommerce.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/all")
    public List<Customer> getAllCustomers () {
        return customerService.findAllCustomer();
    }

    @PostMapping("/create")
    public Customer createCustomer (@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

}
