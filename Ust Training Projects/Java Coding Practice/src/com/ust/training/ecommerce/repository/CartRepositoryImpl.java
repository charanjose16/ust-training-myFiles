package com.ust.training.ecommerce.repository;

import com.ust.training.ecommerce.model.Product;

import java.util.*;

public class CartRepositoryImpl implements cartRepository{

    Map<Integer,Product> products=new HashMap<>();


    public void addProduct(Product product) {
        products.put(product.getProdId(),product);
    }

    public Product findProduct(int id) {
        if(products.containsKey(id))
            return products.get(id);
        return null;
    }


    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }


}
