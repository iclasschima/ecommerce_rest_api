package com.ecommerce.service.customer;

import com.ecommerce.data.DTO.customer.CustomerDTO;
import com.ecommerce.data.exceptions.CustomerException;
import com.ecommerce.data.model.Customer;
import com.ecommerce.data.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import java.util.List;


@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    Customer customer;

    @Override
    public Customer saveCustomer(Customer customer) throws CustomerException {
        customer.setPassword(encryptPassword(customer.getPassword()));
        return customerRepository.saveCustomer(customer);
    }

    private String encryptPassword (String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(password);
    }

    @Override
    public Customer findByCustomerId(Integer id) {
        return  customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteCustomerById(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer updateCustomer(Customer customer) throws CustomerException {

        if (customer.getId() == null) {
            throw new CustomerException("Id cannot be null");
        }

        Customer existingCustomer = customerRepository.findById(customer.getId()).orElse(null);

        if (existingCustomer == null) {
            throw new CustomerException("Customer do not exist");
        }

        if (customer.getContact() != null) {
            existingCustomer.setContact(customer.getContact());
        }

        if (customer.getPassword() != null) {
            existingCustomer.setPassword(customer.getPassword());
        }

        return customerRepository.saveCustomer(existingCustomer);
    }
}
