package com.example.mod3;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }
    public Product create(Product product){
        return repository.save(product);
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Product update(Long id, Product product) {
        Product oldProduct = repository.findById(id).orElseThrow();

        oldProduct.setName(product.getName());
        oldProduct.setPrice(product.getPrice());

        return repository.save(oldProduct);
    }
    public void delete(Long id){
        repository.deleteById(id);
    }
}

