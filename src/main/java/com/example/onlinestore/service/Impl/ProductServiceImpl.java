package com.example.onlinestore.service;

import com.example.onlinestore.exception.ResourceNotFoundException;
import com.example.onlinestore.model.Product;
import com.example.onlinestore.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

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
    public Product getProductById(long id) {
//       Optional<Product>  product = Optional.of(productRepository.getById(id));
//       if (product.isPresent()){
//           return product.get();
//       }else {
//           throw new ResourceNotFoundException("Product","id",id);
//       }
        return productRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Product","id",id));
    }

    @Override
    public Product updateProduct(Product product, long id) {
        // check if the product with the given id exists in the DB
        Product existingProduct = productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Product","id",id));

        existingProduct.setTitle(product.getTitle());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setProductType(product.getProductType());

        // save the new product in the DB
        productRepository.save(existingProduct);


        return existingProduct;
    }

    @Override
    public void deleteProduct(long id) {
        // check whether the product exists in the DB
        productRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Product","id",id));

        productRepository.deleteById(id);
    }
}
