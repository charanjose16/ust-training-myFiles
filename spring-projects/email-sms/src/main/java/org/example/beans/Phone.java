package org.example.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Phone {
    @Value("${phone.brand}")
    private String brand;
    @Value("${phone.model}")
    private String model;
    @Value("${phone.price}")
    private double price;

    public Phone() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Phone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    @Override
    public String toString() {
        return  "Phone Details : " +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price + "\n"
                ;
    }
}
