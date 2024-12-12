package com.ust.training.Swiggy.repository;

import com.ust.training.Swiggy.model.Customer;

import java.util.PriorityQueue;
import java.util.Queue;

public class CustomerRepositoryImpl implements CustomerRepository {

    Queue<Customer> customers=new PriorityQueue<>();

    public void addNewCustomer(Customer customer) {
        customers.offer(customer);
    }

    public Queue<Customer> getAllCustomers() {
        return customers;
    }
}
