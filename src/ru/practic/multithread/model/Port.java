package ru.practic.multithread.model;

import java.util.ArrayList;
import java.util.List;

public class Port {
    private final int capasity;
    private List<Integer> warehouse;

    public Port(Integer capasity) {
        this.capasity = capasity;
        warehouse= new ArrayList<>(capasity);
        for (int i = 0; i < capasity; i++) {
            warehouse.add(i);
        }
    }

    public synchronized void unload(int size) {
        if (warehouse.size() > size) {
            for (int i = 0; i < size; i++) {
                warehouse.remove(i);
            }
            System.out.println("Количество груза на складе = " + warehouse.size());
        } else {
            System.out.println("Не смог отгрузить груз на корабль");
        }
    }

    public List<Integer> getWarehouse() {
        return warehouse;
    }
}
