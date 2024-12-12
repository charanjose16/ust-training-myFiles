package com.ust.training.code_practice;

import java.util.Scanner;

public class CurrencyConverter {

    static float SourceSolution(float amount,float currencyAmount){
        return amount*currencyAmount;
    }

    public static void main(String[] args) {
        System.out.println("Enter the amount you want to convert : ");
        Scanner sc=new Scanner(System.in);
        float input = sc.nextInt();

        System.out.println("1.USD");
        System.out.println("2.EUR");
        System.out.println("3.INR");
        System.out.println("Select the source currency");
        int sType= sc.nextInt();
        System.out.println("Select the destination currency");
        int dType= sc.nextInt();


        float output=switch (sType){
            case 1->SourceSolution(input,83.79f);
            case 2-> SourceSolution(input,92.80f);
            case 3->SourceSolution(input,1f);
            default -> {
                System.out.println("invalid choice");
                yield 0;
                  }
            };

        float output2=switch (dType){
            case 1->SourceSolution(output,0.012f);
            case 2-> SourceSolution(output,0.011f);
            case 3->SourceSolution(output,1f);
            default -> {
                System.out.println("invalid choice");
                yield 0;
            }
        };

        System.out.println(" Final Convertion Amount: " +output2);
        }
    }

