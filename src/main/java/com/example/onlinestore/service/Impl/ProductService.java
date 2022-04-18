package com.example.onlinestore.service.Impl;

import com.example.onlinestore.Repository.ProductRepository;
import com.example.onlinestore.exception.ResourceNotFoundException;
import com.example.onlinestore.model.Product;
import com.example.onlinestore.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService implements IProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
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
       /* Optional<Product> product = productRepository.findById(id);
        return product.get();
*/
        return productRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Product", "id", id));
    }

    @Override
    public Product updateProduct(Product product, Long id) {
        Product existingProduct = productRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Product", "id", id));


        existingProduct.setTitle(product.getTitle());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setProductType(product.getProductType());

        productRepository.save(existingProduct);
        return existingProduct;
    }

    public void deleteProduct(Long id) {
        productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));

        productRepository.deleteById(id);
    }


}
