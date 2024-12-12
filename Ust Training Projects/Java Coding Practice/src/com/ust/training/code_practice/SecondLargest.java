package com.ust.training.code_practice;

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr=new int[] {2,33,4,15,45,46,60,23};

        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }

        }

        System.out.println( arr[arr.length-2]);

    }
}
