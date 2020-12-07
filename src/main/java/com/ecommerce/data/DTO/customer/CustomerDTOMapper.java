package com.ecommerce.data.DTO.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ecommerce.data.model.Customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomerDTOMapper {

    @Autowired
    CustomerDTO customerDTO;

    Customer customer;

    public CustomerDTOMapper () {
        customer = new Customer();
    }

    public CustomerDTO setCustomerToCustomerDTO(Customer customer) {

        customerDTO.setContact(customer.getContact());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setId(customer.getId());
        customerDTO.setPassword(customer.getPassword());

        return customerDTO;
    }

    public List<CustomerDTO> setCustomerToCustomerDTO(List<Customer> customers) {

        log.info("customers -> {}", customers);

        List<CustomerDTO> customerDTOS = new ArrayList<>();

        for (Customer customer : customers) {
            log.info("customers -> {}", setCustomerToCustomerDTO(customer));
//            customerDTOS.add(setCustomerToCustomerDTO(customer));
        }

        return customerDTOS;
    }

    public Customer setCustomerDTOToCustomer(CustomerDTO customerDTO) {

        customer.setContact(customerDTO.getContact());
        customer.setEmail(customerDTO.getEmail());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setId(customerDTO.getId());
        customer.setPassword(customerDTO.getPassword());

        return customer;
    }



}
