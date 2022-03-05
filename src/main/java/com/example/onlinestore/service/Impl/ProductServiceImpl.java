package com.example.onlinestore.service.Impl;

import com.example.onlinestore.Repository.ProductRepository;
import com.example.onlinestore.model.Product;
import com.example.onlinestore.service.ProductService;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
       Optional <Product> product= productRepository.findById(id);
        return product.get();
    }
}
