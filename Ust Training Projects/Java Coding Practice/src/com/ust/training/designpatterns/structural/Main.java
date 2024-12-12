package com.ust.training.designpatterns.structural;

public class Main {

    public static void main(String[] args) {
        AndroidPhone phone1=new AndroidPhone();
//        phone1.charge();

        LightningToTypeCAdapter adapter=new LightningToTypeCAdapter(phone1);
        adapter.chargeWithLightning();

    }
}
