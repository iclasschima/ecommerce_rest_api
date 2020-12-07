package com.ecommerce.data.DTO.customer;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class CustomerDTO {
    
    private Integer id;
    private String firstName;
    private String lastName;
    private String contact;
    private String email;
    private String password;
}
