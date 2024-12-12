package com.ust.training.ecommerce.model;

public class Electronics extends Product{
    private String brand;
    private int warrantyPeriod;

    public Electronics(String prodName, int prodId, double price, int quantityStock, String brand, int warrantyPeriod) {
        super(prodName, prodId, price, quantityStock);
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Brand : "+brand);
        System.out.println("Warranty Period : "+warrantyPeriod +" years");
    }
}
