package com.ust.training.designpatterns.structural;

public class LightningToTypeCAdapter implements LightningCharger{
    AndroidPhone phone;

    @Override
    public void chargeWithLightning() {
        System.out.println("Lightning to Type C");
        phone.charge();
    }

    public LightningToTypeCAdapter(AndroidPhone phone){
        this.phone=phone;
    }
}
