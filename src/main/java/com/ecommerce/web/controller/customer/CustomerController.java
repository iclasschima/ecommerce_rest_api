package com.ecommerce.web.controller.customer;

import com.ecommerce.data.DTO.customer.CustomerDTO;
import com.ecommerce.data.DTO.customer.CustomerDTOMapper;
import com.ecommerce.data.exceptions.CustomerException;
import com.ecommerce.data.model.Customer;
import com.ecommerce.service.customer.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerDTOMapper customerDTOMapper;

    @GetMapping("/all")
    public ResponseEntity<Object> getAllCustomers() {
        List<Customer> customers = customerService.findAllCustomer();

        log.info("cus -> {}", customers);
//        List<CustomerDTO> customerDTOS = customerDTOMapper.setCustomerToCustomerDTO(customers);

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCustomer(@RequestBody CustomerDTO customerDTO) {
        try {
            customerService.saveCustomer(customerDTOMapper.setCustomerDTOToCustomer(customerDTO));
        } catch (CustomerException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateCustomer(@RequestBody CustomerDTO customerDTO) {

        try {
            customerService.updateCustomer(customerDTOMapper.setCustomerDTOToCustomer(customerDTO));
        } catch (CustomerException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomerById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findCustomerById(@PathVariable Integer id) {
        Customer customer = customerService.findByCustomerId(id);
        return new ResponseEntity<>(customerDTOMapper.setCustomerToCustomerDTO(customer), HttpStatus.OK);
    }

}
