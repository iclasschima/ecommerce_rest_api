package com.ecommerce.data.repository;

import com.ecommerce.data.model.Address;
import com.ecommerce.data.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Sql(scripts = "classpath:db/insert.sql")
class AddressRepositoryTest {

    @Autowired
    AddressRepository addressRepository;

    @Autowired CustomerRepository customerRepository;

    Address address;

    @BeforeEach
    void setUp() {
        address = new Address();
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void testThatWeCanSaveAnAddress () {
        address.setState("Lagos");
        address.setCity("Yaba");
        address.setCountry("Nigeria");
        address.setStreet("312 Herbert Macaulay way, Sabo");
        address.setZipcode("1100110");

        Customer customer = customerRepository.findById(1).get();
        address.setCustomers(customer);

        assertDoesNotThrow(() ->  addressRepository.saveAddress(address));
    }

    @Test
    void testThatWeCanUpdateAddress () {
        address = addressRepository.findById(1).orElse(null);
        address.setZipcode("100110");
        addressRepository.save(address);

        assertThat(address.getZipcode()).isEqualTo("100110");
        log.info("Address -> {}", address);
    }

    @Test
    void testThatWeCanDeleteAddress () {
        assertThat(addressRepository.existsById(1)).isTrue();
        addressRepository.deleteById(1);
        assertThat(addressRepository.existsById(1)).isFalse();
    }

    @Test
    void testThatWeGetAllAddresses () {
        List<Address> addresses = addressRepository.findAll();
        assertThat(addresses).isNotEmpty();
    }

}