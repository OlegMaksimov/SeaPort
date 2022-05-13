package ru.practic.multithread.model;

public abstract class Ship {
    //    грузоподьемность
    public final int CAPASITY;
    private int count;

    protected Ship(int CAPASITY) {
        this.CAPASITY = CAPASITY;
    }

    public void add(int count) {
        this.count += count;
    }


}
