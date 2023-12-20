package seventh_lab;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class sum {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int numThreads = 2; // Задается количество потоков 

        ExecutorService executor = Executors.newFixedThreadPool(numThreads); // исполнитель для выполнения потоков с фиксированным количеством numThreads

        int chunkSize = (int) Math.ceil((double) array.length / numThreads); //Вычисляется размер порции элементов массива, которую будет обрабатывать каждый поток.
        int start = 0; //Инициализируется переменная start для хранения индекса начала порции элементов массива, откуда будет производиться копирование.

        //Начинается цикл по количеству потоков.
        for (int i = 0; i < numThreads; i++) {
            int end = Math.min(start + chunkSize, array.length); //Вычисляется индекс конца порции элементов массива.
            int[] subArray = new int[end - start]; //будет содержать порцию элементов из array
            System.arraycopy(array, start, subArray, 0, subArray.length); //Копируются элементы из array в subArray 
            executor.execute(new SumWorker(subArray)); //Запускается выполнение нового потока, передавая в конструктор SumWorker порцию элементов subArray.
            start = end;
        }

        executor.shutdown();


        //ожидается завершение работы всех потоков исполнителя.
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int totalSum = SumWorker.getTotalSum();
        System.out.println("Total sum: " + totalSum);
    }
}

class SumWorker implements Runnable {
    private int[] array;
    private static int totalSum = 0;

    public SumWorker(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        int partialSum = 0;
        for (int num : array) {
            partialSum += num;
        }
        synchronized (SumWorker.class) {
            totalSum += partialSum;
        }
    }

    public static int getTotalSum() {
        return totalSum;
    }
}