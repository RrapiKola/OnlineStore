package com.example.onlinestore.controller;

import com.example.onlinestore.model.Product;
import com.example.onlinestore.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

   private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product>saveProduct(@RequestBody Product product){
        return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);

    }

    @GetMapping
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public ResponseEntity<Product>getProductById(@PathVariable("id") Long id){
        return new ResponseEntity<Product>(productService.getProductById(id),HttpStatus.OK);

    }
}
