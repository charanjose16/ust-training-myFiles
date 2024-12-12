package com.ust.training.ecommerce.repository;

import com.ust.training.ecommerce.model.Product;

import java.util.List;

public interface productRepository {
    public void addProducts(Product product);
    public List<Product> viewAllProducts();
}
