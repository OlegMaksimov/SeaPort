package ru.practic.multithread.model;

import java.util.concurrent.TimeUnit;

/**
 * @author www.epam.com
 */
public class PortManager implements Runnable{
    private final Port port;
    private final Ship ship;

    public PortManager(Port port, Ship ship) {
        this.port = port;
        this.ship = ship;
    }

    @Override
    public void run() {
        while (true) {
            if (port.getWarehouse().size() > 0 && port.getWarehouse().size() > ship.CAPASITY) {
                System.out.println("Готовится погрузка на корабль " + ship);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                port.unload(ship.CAPASITY);
                System.out.println("Закончил погрузку на корабль "+ ship);
            } else {
                System.out.println("склад пуст! " + ship);
                break;
            }
        }
    }
}
