package com.ust.training.ecommerce.service;

import com.ust.training.ecommerce.Exceptions.DuplicateProductException;
import com.ust.training.ecommerce.Exceptions.InvalidInputException;
import com.ust.training.ecommerce.Exceptions.ProductNotFoundException;
import com.ust.training.ecommerce.model.Clothing;
import com.ust.training.ecommerce.model.Electronics;
import com.ust.training.ecommerce.model.Product;
import com.ust.training.ecommerce.repository.CartRepositoryImpl;
import com.ust.training.ecommerce.repository.cartRepository;
import com.ust.training.ecommerce.repository.productRepository;
import com.ust.training.ecommerce.repository.productRepositoryImpl;

import javax.swing.*;
import java.security.PublicKey;
import java.util.List;

public class cartServiceImpl implements cartService{

    private cartRepository cartRepo=new CartRepositoryImpl();
    private productRepository prodRepo=new productRepositoryImpl();

    public void addTocart(int id) {
        List<Product> product=prodRepo.viewAllProducts();
        for(Product p:product){
            if(p.getProdId()==id){
                cartRepo.addProduct(p);
            }
        }
    }

    public void getCartItems() {

        List<Product> products=cartRepo.getAllProducts();
        System.out.println("Available Products : ");
        System.out.println();
        for(Product p:products){
            System.out.println("ID : "+p.getProdId());
            System.out.println("Product Name : "+p.getProdName());
            System.out.println("Product Price : "+p.getPrice());
            System.out.println();
        }
    }

    public void findProductById(int id) throws ProductNotFoundException {
        List<Product> products=prodRepo.viewAllProducts();
        int ProductIsPresent=0;
        for(Product p:products){
            if(p==null){
                break;
            }
            else if(p.getProdId()==id){
                System.out.println(p.getProdName());
                ProductIsPresent+=1;
            }
        }
        if(ProductIsPresent<=0){
            throw new ProductNotFoundException("Product Id not Found");
        }

    }

    public double calculateTotalPrice() {
        List<Product> products=cartRepo.getAllProducts();
        double totalPrice=0;
        for(Product p:products){
            if(p==null){
                break;
            }
            totalPrice+=p.getPrice();
        }
        return totalPrice;
    }

    public void discountPrice() {
        List<Product> products=cartRepo.getAllProducts();
        for(Product p:products){
            if(p==null){
                break;
            }
            else if(p instanceof Electronics){
                double price=p.getPrice();
                price=price-price*.10;
                p.setPrice(price);
            }
            else if(p instanceof Clothing){
                double price=p.getPrice();
                price=price-price*.20;
                p.setPrice(price);
            }

        }

    }


    public void addToProduct(Product product) throws DuplicateProductException,InvalidInputException{
        List<Product> products=prodRepo.viewAllProducts();
        if(product.getProdId()>0 && product.getProdName()!=null && product.getPrice()>0){
            for(Product p:products){
                if(p==null){
                    break;
                }
                else if(p.getProdId()==product.getProdId()){
                    throw new DuplicateProductException("Product ID is already present");
                }

            }
            prodRepo.addProducts(product);

        }
        else {
            throw new InvalidInputException("Invalid Input Exception");
        }

    }

    public void getProducts() {
        List<Product> products=prodRepo.viewAllProducts();
        System.out.println("Available Products : ");
        System.out.println();
        for(Product p:products){
            if(p==null){
                break;
            }
            System.out.println("ID : "+p.getProdId() +" Product Name : "+p.getProdName());
        }

    }

}
