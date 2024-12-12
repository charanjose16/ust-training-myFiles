package com.ust.training.code_practice;

import java.util.Random;
import java.util.Scanner;

public class MysteriousGuesser {
    public static void main(String[] args) {
        final int MAX_ATTEMPTS=10;
        System.out.println("Welcome to the Mysterious Number Guesser!");
        System.out.println("I have selected a number between 1 to 100 can you guess it?");
        Random rn = new Random();
        int answer = rn.nextInt(100) + 1;


        for(int i=0;i<MAX_ATTEMPTS;i++){
            System.out.print("Enter your guess : ");
            Scanner input= new Scanner(System.in);
            int gNumber=input.nextInt();
            int diff=Math.abs(gNumber-answer);
            if(i==MAX_ATTEMPTS-1){
                System.out.println("You've reached maximum attempts!");
                System.out.println("The Mystery Number is : " +answer);
                break;
            }
            else if(gNumber>=1 && gNumber<=100) {
                if(i>(MAX_ATTEMPTS/2)-1){
                    if(diff <= 10) {
                        if (gNumber < answer) {
                            System.out.println("Move forward!");
                            continue;
                        } else {
                            System.out.println("Move backward!");
                        }
                    }
                    else{
                        System.out.println("The Random number starts with : " +answer/10 +"_" );
                    }
                }
                else {
                    if (diff == 0) {
                        System.out.println("Congratulation! you guessed the mysterious number!");
                        break;
                    } else if (diff <= 10) {
                        System.out.println("You're getting closer!");

                    } else {
                        System.out.println("you're too far!");

                    }
                }
            }
            else {
                System.out.println("Invalid input");
            }
        }
    }
}
