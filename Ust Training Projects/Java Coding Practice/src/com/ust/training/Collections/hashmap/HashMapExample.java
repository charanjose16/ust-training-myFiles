package com.ust.training.Collections.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapExample {
    public static void main(String[] args) {
        Map<Character,Integer> map= new HashMap<>();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a String : ");
        String strr=sc.nextLine();
        String str = strr.toLowerCase();
        for(int i=0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                int k=map.get(str.charAt(i));
                k++;
                map.put(str.charAt(i),k);
            }
            else{
                map.put(str.charAt(i),1);
            }
        }
        System.out.println(map);
    }
}
