package com.ust.training.Swiggy.model;


public class Customer implements Comparable<Customer> {
    private int custId;
    private String custName;
    private Membership category;

    public Customer(int custId, String custName, Membership category) {
        this.custId = custId;
        this.custName = custName;
        this.category = category;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public Membership getCategory() {
        return category;
    }

    public void setCategory(Membership category) {
        this.category = category;
    }

    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", category=" + category +
                '}';
    }

    @Override
    public int compareTo(Customer o) {
        return this.custId-o.custId;
    }
}

