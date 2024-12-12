package com.ust.training.MultiThreading.Downloader;

public class Downloader implements Runnable{

    public void download(){
        for(int i=0;i<=100;i+=10){
            System.out.println("From "+Thread.currentThread().getName()+" "+i+"% "+" Completed");
        }
        System.out.println("DOWNLOAD COMPLETED");
    }

    @Override
    public void run() {
        download();
    }
}
