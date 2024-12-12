package com.ust.training.ecommerce.repository;

import com.ust.training.ecommerce.model.Product;

import java.util.List;

public interface cartRepository {

    public void addProduct(Product product);
    public Product findProduct(int id);
    public List<Product> getAllProducts();


}
