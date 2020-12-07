package com.ecommerce.service.product;

import com.ecommerce.data.exceptions.ProductException;
import com.ecommerce.data.model.Product;
import com.ecommerce.data.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

class ProductServiceImplTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService = new ProductServiceImpl();

    Product product;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks (this);
        product = new Product();
    }

    @Test
    void testThatWeCanCallTheSaveProductRepository () throws ProductException {
        when(productRepository.saveProduct(product)).thenReturn(product);
        productService.saveProduct(product);
        verify(productRepository, times(1)).saveProduct(product);
    }

    @Test
    void testThatWeCanCallTheDeleteProductRepository () {
        doNothing().when(productRepository).deleteById(1);
        productService.deleteProductById(1);
        verify(productRepository, times(1)).deleteById(1);
    }

    @Test
    void testThatWeCanCallTheFindProductByIdRepository () {
        when(productRepository.findById(1)).thenReturn(Optional.of(product));
        productService.findProductById(1);
        verify(productRepository, times(1)).findById(1);

    }

    @Test
    void testThatWeCanCallTheFindAllProductsRepository () {
        when(productRepository.findAll()).thenReturn(List.of(product));
        productService.findAllProducts();
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testThatWeCanCallTheUpdateProductRepository () throws ProductException {
        when(productRepository.saveProduct(product)).thenReturn(product);
        productService.updateProduct(product);
        verify(productRepository, times(1)).saveProduct(product);
    }
}