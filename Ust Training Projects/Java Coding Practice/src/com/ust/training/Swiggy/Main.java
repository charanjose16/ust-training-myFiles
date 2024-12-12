package com.ust.training.Swiggy;
import com.ust.training.Swiggy.service.CustomerServiceImpl;

public class Main {
    public static void main(String[] args) {
        CustomerServiceImpl addCust=new CustomerServiceImpl() {
        };
        addCust.addProduct();
        addCust.viewAllCustomers();
    }
}
