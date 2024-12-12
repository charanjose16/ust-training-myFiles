package com.ust.training.ExceptionHandling;

public class ArithmeticEx {
    public static void main(String[] args) {
        int a=10;
        int b=0;
        try {
            int div=a/b;
            System.out.println("Division : "+div);
        }
        catch (ArithmeticException ex){
            System.out.println(ex.getMessage());
        }
    }
}
