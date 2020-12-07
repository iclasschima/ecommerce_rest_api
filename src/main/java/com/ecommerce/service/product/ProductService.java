package com.ecommerce.service.product;

import com.ecommerce.data.exceptions.ProductException;
import com.ecommerce.data.model.Product;

import java.util.List;

public interface ProductService {

    public Product saveProduct(Product product) throws ProductException;
    public Product findProductById(Integer id);
    public void deleteProductById(Integer id);
    public List<Product> findAllProducts();
    public Product updateProduct(Product product) throws ProductException;

}
