package com.ecommerce.service.customer;

import com.ecommerce.data.model.Customer;
import com.ecommerce.data.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;

class CustomerServiceImplTest {

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerService customerService = new CustomerServiceImpl();

    Customer customer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks (this);
        customer = new Customer();
    }

    @Test
    void testThatWeCanCallTheSaveCustomerRepository () {
        when(customerRepository.save(customer)).thenReturn(customer);
        customerService.saveCustomer(customer);
        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    void testThatWeCanCallTheFindCustomerByIdRepository () {
        when(customerRepository.findById(1)).thenReturn(Optional.of(customer));
        customerService.findByCustomerId(1);
        verify(customerRepository, times(1)).findById(1);
    }

}