package com.ust.training.ecommerce.model;

public class Clothing extends Product{

    private Size size;
    private String material;

    public Clothing(String prodName, int prodId, double price, int quantityStock, Size size, String material) {
        super(prodName, prodId, price, quantityStock);
        this.size = size;
        this.material = material;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Size : "+size);
        System.out.println("Material : "+material);
    }
}
