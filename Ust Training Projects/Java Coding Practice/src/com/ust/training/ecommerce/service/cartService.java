package com.ust.training.ecommerce.service;

import com.ust.training.ecommerce.Exceptions.DuplicateProductException;
import com.ust.training.ecommerce.Exceptions.InvalidInputException;
import com.ust.training.ecommerce.Exceptions.ProductNotFoundException;
import com.ust.training.ecommerce.model.Product;

public interface cartService {

public void addTocart(int id);
public void getCartItems();
public void findProductById(int id) throws ProductNotFoundException;
public double calculateTotalPrice();
public void discountPrice();
    public void addToProduct (Product product) throws InvalidInputException, DuplicateProductException;
    public void getProducts();
}
