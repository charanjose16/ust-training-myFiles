package com.ust.training.ecommerce.model;

public class Product {
   private String prodName;
   private int prodId;
   private double price;
   private int quantityStock;

    public Product(String prodName, int prodId, double price, int quantityStock) {
        this.prodName = prodName;
        this.prodId = prodId;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public void displayDetails(){
        System.out.println(this.getClass().getSimpleName()+" Details : ");
        System.out.println("Product Name : "+prodName);
        System.out.println("Product Id : "+prodId);
        System.out.println("Price : "+price);
        System.out.println("Quantity Stock : "+quantityStock);
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityStock() {
        return quantityStock;
    }

    public void setQuantityStock(int quantityStock) {
        this.quantityStock = quantityStock;
    }
}
