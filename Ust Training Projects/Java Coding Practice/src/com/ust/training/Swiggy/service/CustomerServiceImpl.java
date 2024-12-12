package com.ust.training.Swiggy.service;

import com.ust.training.Swiggy.model.Customer;
import com.ust.training.Swiggy.model.Membership;
import com.ust.training.Swiggy.repository.CustomerRepositoryImpl;

import java.util.Queue;

public class CustomerServiceImpl implements CustomerService{

    private CustomerRepositoryImpl customers=new CustomerRepositoryImpl();
    public void addProduct() {
        Customer cust1=new Customer(3,"charan", Membership.GOLD);
        customers.addNewCustomer(cust1);
        }

    public void viewAllCustomers() {
       Queue<Customer> allCustomers=customers.getAllCustomers();
       while (!allCustomers.isEmpty()){
           System.out.println(allCustomers.poll());
       }

    }
}
