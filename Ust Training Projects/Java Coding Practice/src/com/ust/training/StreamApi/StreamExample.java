package com.ust.training.StreamApi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<String> list=List.of("Harsh","Charan","Lokesh","Mohit");
        var sort=list.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("reverse order : " +sort );
        List<String> names=sort.stream().filter(i->i.startsWith("H") || i.startsWith("M")).toList();
        System.out.println("Filtered : " +names);
        var str=String.join(",",list);
        System.out.println("String with commas : "+str);
    }
}
