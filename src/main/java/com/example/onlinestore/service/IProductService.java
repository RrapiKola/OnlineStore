package com.example.onlinestore.service;

import com.example.onlinestore.model.Product;

import java.util.List;


public interface IProductService {

    Product saveProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(Long id);



    Product updateProduct(Product product, Long id);
}
