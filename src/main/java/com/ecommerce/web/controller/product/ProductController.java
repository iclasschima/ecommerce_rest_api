package com.ecommerce.web.controller.product;

import com.ecommerce.data.exceptions.ProductException;
import com.ecommerce.data.model.Product;
import com.ecommerce.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<Object> findAllProducts () {
        List<Product> products = productService.findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createProduct (@RequestBody Product product) {
        try {
            productService.saveProduct(product);
        } catch (ProductException productException) {
            return ResponseEntity.badRequest().body(productException.getMessage());
        }
        
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateProduct (@RequestBody Product product) {
        try {
            productService.updateProduct(product);
        } catch (ProductException productException) {
            return ResponseEntity.badRequest().body(productException.getMessage());
        }
       
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct (@PathVariable Integer id) {
        productService.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findProductById (@PathVariable Integer id) {
        Product product = productService.findProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

}
