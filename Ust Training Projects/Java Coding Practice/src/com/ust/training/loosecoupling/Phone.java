package com.ust.training.loosecoupling;

public class Phone {
    private Simable sim;

    public void setSim(Simable sim) {
        this.sim = sim;
    }

    public void call() {
        sim.call();
    }

    public void browse() {
    sim.browse();
    }
}
