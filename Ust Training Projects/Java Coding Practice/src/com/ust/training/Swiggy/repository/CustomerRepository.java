package com.ust.training.Swiggy.repository;

import com.ust.training.Swiggy.model.Customer;

import java.util.Queue;

public interface CustomerRepository {

    public void addNewCustomer(Customer customer);
    public Queue<Customer> getAllCustomers();

}
