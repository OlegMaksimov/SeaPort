package ru.practic.multithread;

import ru.practic.multithread.model.Bulker;
import ru.practic.multithread.model.Port;
import ru.practic.multithread.model.PortManager;
import ru.practic.multithread.model.Ship;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static final int SHIP_COUNT = 5;
    public static final int PORT_CAPASITY = 50;

    public static void main(String[] args) {
        // write your code here
        Port port = new Port(PORT_CAPASITY);
        ExecutorService executorService = Executors.newFixedThreadPool(SHIP_COUNT);
        for (int i = 0; i < SHIP_COUNT; i++) {
            executorService.execute(new PortManager(port, new Bulker(5)));
        }
        executorService.shutdown();
    }
}
