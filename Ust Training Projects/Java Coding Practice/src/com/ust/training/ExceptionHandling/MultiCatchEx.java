package com.ust.training.ExceptionHandling;

public class MultiCatchEx {
    public static void main(String[] args) {
        int[] arr={2,3,4,0};
        try{
            int output =arr[0]/arr[4];
            System.out.println(output);
        }
        catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }
        catch (ArrayIndexOutOfBoundsException ex){
            System.out.println(ex.getMessage());
        }
    }
}
