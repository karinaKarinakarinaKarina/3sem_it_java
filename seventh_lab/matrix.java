package seventh_lab;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class matrix {



    static int[][] matrix = {
            {1, 6, 3, 8},
            {4, 2, 9, 5},
            {7, 3, 5, 2},
            {8, 1, 4, 9}
    };

    static int maxElement = Integer.MIN_VALUE;

    public static void main(String[] args) {

        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        for (int i = 0; i < matrix.length; i++) {
            final int row = i;
            executor.execute(() -> {
                int maxInRow = Integer.MIN_VALUE;
                for (int j = 0; j < matrix[row].length; j++) {
                    if (matrix[row][j] > maxInRow) {
                        maxInRow = matrix[row][j];
                    }
                }
                synchronized (matrix.class) {
                    if (maxInRow > maxElement) {
                        maxElement = maxInRow;
                    }
                }
            });
        }

        executor.shutdown();

        while (!executor.isTerminated()) {
            // ожидаем завершения всех потоков
        }

        System.out.println("Наибольший элемент: " + maxElement);
    }
}

