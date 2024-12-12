package com.ust.training.FileHandling;

import java.io.*;
import java.util.Scanner;

public class ReaderAndWriter {
    public static void main(String[] args) throws IOException {

        Scanner sc=new Scanner(System.in);
        int ch;
        while (1>0) {

            System.out.println("""
                  
                    1.Read File
                    2.Write File
                    """);
            int choice = sc.nextInt();

            switch (choice) {

                case 1: {

                    try (Reader reader = new FileReader("demofile.txt");) {
                        while ((ch = reader.read()) != -1) {
                            System.out.print((char) ch);
                        }
                        System.out.println();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                }

                case 2: {
                    System.out.println("Write a text to add : ");
                    String inputString = new Scanner(System.in).nextLine();
                    try (Writer writer = new FileWriter("demofile.txt", true)) {
                        writer.append(" "+inputString);
                    } catch (IOException ex) {
                        System.err.println(ex.getMessage());
                    }
                    break;
                }
            }
        }

    }
}
