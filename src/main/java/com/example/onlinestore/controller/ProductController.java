package com.example.onlinestore.controller;

import com.example.onlinestore.model.Product;
import com.example.onlinestore.model.User;
import com.example.onlinestore.service.Impl.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping()
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }


    @PutMapping("{id}")
    public Product updateUser(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.updateProduct(product, id);
    }

    @DeleteMapping("{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);

        return "Product deleted!";
    }

}
