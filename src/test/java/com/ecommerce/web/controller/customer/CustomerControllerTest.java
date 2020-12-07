package com.ecommerce.web.controller.customer;

import com.ecommerce.data.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper mapper;

    Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer();
        mapper = new ObjectMapper();
    }

    @Test
    void testCreateCustomerEndpoint_thenReturnOK() throws Exception {
        customer.setFirstName("Obi");
        customer.setLastName("Sam");
        customer.setPassword("samdjd");
        customer.setContact("09031222222");
        customer.setEmail("obisam@gmail.com");

        this.mockMvc
                .perform(post("/customer/create").contentType("application/json")
                        .content(mapper.writeValueAsString(customer)))
                .andDo(print()).andExpect(status().isCreated()).andReturn();
    }

    @Test
    void testFindAllCustomerEndpoint_thenReturnOK() throws Exception {
        this.mockMvc.perform(get("/customer/all")).andDo(print()).andExpect(status().isOk()).andReturn();
    }

    @Test
    void testUpdateCustomerEndpoint_thenReturnOK() throws Exception {
        customer.setId(6);
        customer.setFirstName("Uche");

        this.mockMvc
                .perform(post("/customer/update").contentType("application/json")
                        .content(mapper.writeValueAsString(customer)))
                .andDo(print()).andExpect(status().isOk()).andReturn();
    }

    @Test
    void testDeleteCustomerEndpoint_thenReturnOK () throws Exception {
        this.mockMvc.perform(delete("/customer/2")).andDo(print()).andExpect(status().isOk()).andReturn();
    }

    @Test
    void testFindCustomerById_thenReturnCustomerDTOObject () throws Exception {
        this.mockMvc.perform(get("/customer/4")).andDo(print()).andExpect(status().isOk()).andReturn();
    }
}