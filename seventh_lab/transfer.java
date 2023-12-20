package seventh_lab;

import java.util.concurrent.CountDownLatch;

public class transfer {
    public static void main(String[] args) {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(3);

        Warehouse warehouse = new Warehouse(startSignal, doneSignal);

        Thread loader1 = new Thread(new Loader(warehouse, "Loader 1"));
        Thread loader2 = new Thread(new Loader(warehouse, "Loader 2"));
        Thread loader3 = new Thread(new Loader(warehouse, "Loader 3"));

        loader1.start();
        loader2.start();
        loader3.start();

        startSignal.countDown(); // начало переноса товаров

        try {
            doneSignal.await(); // ожидание завершения переноса товаров
            System.out.println("All goods have been transferred to the other warehouse");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Warehouse {
    CountDownLatch startSignal;
    private CountDownLatch doneSignal;
    private int totalWeight = 0;

    public Warehouse(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    public synchronized void transferGoods(int weight, String loaderName) {
        while (totalWeight + weight > 150) {
            try {
                wait(); // ожидание освобождения места для товаров
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        totalWeight += weight;
        System.out.println(loaderName + " transferred " + weight + " kg of goods. Total weight: " + totalWeight);

        if (totalWeight == 150) {
            System.out.println("All goods have been transferred. " + loaderName + " is going to the other warehouse");
            totalWeight = 0;
            notifyAll(); // оповещение о разгрузке товаров
            doneSignal.countDown(); // уменьшение счетчика завершения
        }
    }
}

class Loader implements Runnable {
    private Warehouse warehouse;
    private String name;

    public Loader(Warehouse warehouse, String name) {
        this.warehouse = warehouse;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            warehouse.startSignal.await(); // ожидание начала переноса товаров
            warehouse.transferGoods(50, name);
            warehouse.transferGoods(70, name);
            warehouse.transferGoods(30, name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}