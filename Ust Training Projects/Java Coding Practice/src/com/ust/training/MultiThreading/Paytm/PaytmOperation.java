package com.ust.training.MultiThreading.Paytm;

import com.ust.training.Swiggy.repository.CustomerRepositoryImpl;

public class PaytmOperation {

    double balance;

    public PaytmOperation(double balance) {
        this.balance = balance;
    }

    synchronized void addMoney(double amount) {
        System.out.println("Adding Money Rs:"+amount);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.balance = balance + amount;
        System.out.println("Money added ");
        System.out.println("New balance : " + balance);
        notify();
    }

    synchronized void payBill(double amount) {
        System.out.println("Current Balance : "+balance);
        while (balance < amount) {
            System.out.println("Balance is low");
        try {
              wait();
            }
     catch(InterruptedException e)
          {
              Thread.currentThread().interrupt();
              throw new RuntimeException(e);

          }
}
        balance-=amount;
        System.out.println("Bill paid, New balance is : "+balance);

    }

    public static void main(String[] args) {

        PaytmOperation paytm=new PaytmOperation(100);

        Thread PaybillThread=new Thread(()-> paytm.payBill(350));
        Thread addMoneyThread =new Thread(()-> paytm.addMoney(450));

        PaybillThread.start();
        addMoneyThread.start();



    }

}

