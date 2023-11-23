package collections_lab;

import java.util.concurrent.ConcurrentHashMap;

public class sales {
    private ConcurrentHashMap<String, Integer> sales; // Хранение продаж в ConcurrentHashMap

    public sales() {
        sales = new ConcurrentHashMap<>();
    }

    // Метод для добавления проданных товаров
    public void addSale(String item, int quantity) {
        // Используем операцию compute для обновления количества продаж товара
        sales.compute(item, (key, value) -> value != null ? value + quantity : quantity);
    }

    // Метод для вывода списка проданных товаров
    public void printSales() {
        for (String item : sales.keySet()) {
            int quantity = sales.get(item);
            System.out.println("Товар: " + item + ", количество продаж: " + quantity);
        }
    }

    // Метод для подсчета общей суммы продаж
    public int calculateTotalSales() {
        int totalSales = 0;
        for (int quantity : sales.values()) {
            totalSales += quantity;
        }
        return totalSales;
    }

    // Метод для получения наиболее популярного товара
    public String getMostPopularItem() {
        String mostPopularItem = null;
        int maxQuantity = 0;
        for (String item : sales.keySet()) {
            int quantity = sales.get(item);
            if (quantity > maxQuantity) {
                mostPopularItem = item;
                maxQuantity = quantity;
            }
        }
        return mostPopularItem;
    }

    public static void main(String[] args) {
        sales tracker = new sales();
        tracker.addSale("Товар1", 5);
        tracker.addSale("Товар2", 3);
        tracker.addSale("Товар1", 2);
        tracker.addSale("Товар3", 1);

        tracker.printSales();
        System.out.println("Общая сумма продаж: " + tracker.calculateTotalSales());
        System.out.println("Наиболее популярный товар: " + tracker.getMostPopularItem());
    }
}