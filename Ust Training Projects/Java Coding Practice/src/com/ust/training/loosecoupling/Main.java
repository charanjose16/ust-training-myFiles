package com.ust.training.loosecoupling;

public class Main {
    public static void main(String[] args) {
        Phone sim= new Phone();
        AirtelSim aSim=new AirtelSim();
        sim.setSim(aSim);
        sim.call();
        JioSim jSim=new JioSim();
        sim.setSim(jSim);
        sim.browse();

    }
}
