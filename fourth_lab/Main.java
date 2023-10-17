
public class Main {
    public static void main(String[] args) {
        HashTable employees = new HashTable(10);

        // Добавление сотрудников
        Employee employee1 = new Employee(1, "John", "Manager", 5000);
        Employee employee2 = new Employee(2, "Alice", "Developer", 4000);
        Employee employee3 = new Employee(3, "Bob", "Designer", 3000);

        employees.put(employee1.getId(), employee1);
        employees.put(employee2.getId(), employee2);
        employees.put(employee3.getId(), employee3);

        // Получение сотрудника по ID
        Employee retrievedEmployee = employees.get(2);
        System.out.println(retrievedEmployee.getName()); // Выводит "Alice"

        // Удаление сотрудника
        employees.remove(1);

        // Проверка размера и пустоты таблицы
        System.out.println(employees.size()); // Выводит 2
        System.out.println(employees.isEmpty()); // Выводит false
    }
}
