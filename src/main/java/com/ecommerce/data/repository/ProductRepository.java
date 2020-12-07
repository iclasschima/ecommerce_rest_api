package com.ecommerce.data.repository;

import com.ecommerce.data.exceptions.ProductException;
import com.ecommerce.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    public default Product saveProduct(Product product) throws ProductException {

        if (isProductValid(product)) {
            product = save(product);
        }

        return product;
    }

    private boolean isProductValid(Product product) throws ProductException {
        
        if (!isProductNull(product)) {
            throw new ProductException("Product cannot be null");
        }
        
        if (!productHasName(product)) {
            throw new ProductException("Product name cannot be empty");
        }

        if (!productHasQuantity(product)) {
            throw new ProductException("Product quantity not set");
        }

        if (!productHasPrice(product)) {
            throw new ProductException("Product price not set");
        }

        return true;
    }

    private boolean isProductNull (Product product) {
        return product != null;
    }

    private boolean productHasName(Product product) {
        return product.getName() != null;
    }

    private boolean productHasQuantity(Product product) {
        return product.getQuantity() != null;
    }

    private boolean productHasPrice(Product product) {
        return product.getPrice() != null;
    }
}
