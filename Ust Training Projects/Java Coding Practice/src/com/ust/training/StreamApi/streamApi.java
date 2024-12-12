package com.ust.training.StreamApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class streamApi {

    public static List<Integer> getEvens(List<Integer> list){
        List<Integer> even=new ArrayList<>();
        list.forEach(n->{
            if (n % 2 == 0) {
                even.add(n);
            }});
        return even;
    }
    public static List<Integer> getSquare(List<Integer> list){
        List<Integer> squares=new ArrayList<>();
        list.forEach(n->{
                squares.add(n*n);
            });
        return squares;
    }
    public static int sum(List<Integer> list){
        int Sum = 0;
        for(int num:list){
            Sum+=num;
        }
        return Sum;
    }

    public static void main(String[] args) {

        List<Integer> list=List.of(2,3,4,5,6);
        var evens=getEvens(list);
        var squares=getSquare(evens);
        int sum1=sum(squares);
        System.out.println(sum1);

        //Stream method
        int sum2=list.stream().filter(i->i%2==0).mapToInt(i->i*i).sum();
        System.out.println(sum2);
    }
}
