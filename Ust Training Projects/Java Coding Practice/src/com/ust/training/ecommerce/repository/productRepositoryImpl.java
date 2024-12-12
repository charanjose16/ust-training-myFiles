package com.ust.training.ecommerce.repository;

import com.ust.training.ecommerce.model.Product;

import java.util.ArrayList;
import java.util.List;

public class productRepositoryImpl implements productRepository{

    List<Product> products=new ArrayList<>();
    public void addProducts(Product product) {
        products.add(product);

    }

    public List<Product> viewAllProducts() {
        return products;
    }

}
