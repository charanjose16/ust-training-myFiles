package com.ust.training.MultiThreading.Downloader;

public class Main {
    public static void main(String[] args) {

         Downloader downloader=new Downloader();

         Thread downloader1=new Thread(downloader::download);
        Thread downloader2=new Thread(downloader::download);

        downloader1.setName("Downloader 1");
        downloader2.setName("Downloader 2");

        downloader1.start();
        downloader2.start();



    }
}
