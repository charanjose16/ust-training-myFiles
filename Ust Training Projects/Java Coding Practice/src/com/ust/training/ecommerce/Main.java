package com.ust.training.ecommerce;

import com.ust.training.ecommerce.Exceptions.DuplicateProductException;
import com.ust.training.ecommerce.Exceptions.ProductNotFoundException;
import com.ust.training.ecommerce.model.Clothing;
import com.ust.training.ecommerce.model.Electronics;
import com.ust.training.ecommerce.model.Product;
import com.ust.training.ecommerce.model.Size;
import com.ust.training.ecommerce.service.cartService;
import com.ust.training.ecommerce.service.cartServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {


//        double totalPrice=cartService.calculateTotalPrice();
//        System.out.println("Total Price : "+totalPrice);
//        cartService.discountPrice();
//
//        double discountPrice=cartService.calculateTotalPrice();
//        System.out.println("Discount Price : "+discountPrice);


        cartService cartService=new cartServiceImpl();

        try {
            cartService.addToProduct(new Electronics("Iphone 15",217,129000,8,"Apple",1));
        } catch (DuplicateProductException e) {
            throw new RuntimeException(e);
        }
        try {
            cartService.addToProduct(new Electronics("Iphone 14",218,113000,3,"Apple",1));
        } catch (DuplicateProductException e) {
            throw new RuntimeException(e);
        }
//        cartService.addToProduct(new Clothing("Shirt",298,1100,27,Size.MEDIUM,"Cotton"));
//        cartService.addToProduct(new Electronics("Iphone 11",206,54000,9,"Apple",1));
//        cartService.addToProduct(new Clothing("Saree",211,1200,5,Size.SMALL,"Silk"));


        while(1>0){

            System.out.println();
            System.out.println("1. Show Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Find Product");
            System.out.println();
            Scanner sc=new Scanner(System.in);
            int choice=sc.nextInt();

            if(choice==1){
                cartService.getProducts();
            }
            else if(choice==2){
                System.out.println("Enter Product Id : ");
                int prodIdToCart=sc.nextInt();
                cartService.addTocart(prodIdToCart);
            } else if (choice==3) {
                cartService.getCartItems();
            }
            else if(choice==4){
                try {
                    System.out.println("Enter product id : ");
                    int findProdId=sc.nextInt();
                    cartService.findProductById(findProdId);
                } catch (ProductNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }



}
