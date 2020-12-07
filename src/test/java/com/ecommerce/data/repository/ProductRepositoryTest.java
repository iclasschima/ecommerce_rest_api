package com.ecommerce.data.repository;

import com.ecommerce.data.exceptions.ProductException;
import com.ecommerce.data.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    Product product;

    @BeforeEach
    void setUp() {
        product = new Product();
    }

    @Test
    void testThatWeCanSaveAProduct() {
        product.setName("Garlic");
        product.setPrice(200.00);
        product.setDescription("Garlic is sweet");
        product.setExpDate("12-10-12");
        product.setQuantity(10);

        assertDoesNotThrow(() -> productRepository.saveProduct(product));
    }

    @Test
    void testSaveProductWithoutName() {
        product.setPrice(200.00);
        product.setDescription("Garlic is sweet");
        product.setExpDate("12-10-12");
        product.setQuantity(10);

        assertThrows(ProductException.class, () -> productRepository.saveProduct(product));
    }

    @Test
    void testSaveProductWithoutProduct() {

        assertThrows(ProductException.class, () -> productRepository.saveProduct(null));
    }
}