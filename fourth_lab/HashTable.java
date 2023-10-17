import java.util.LinkedList;

public class HashTable {
    private LinkedList<Employee>[] table;
    private int capacity;
    private int size;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public void put(int key, Employee value) {
        int index = hash(key);
        LinkedList<Employee> list = table[index];
        for (Employee employee : list) {
            if (employee.getId() == key) {
                employee.setName(value.getName());
                employee.setPosition(value.getPosition());
                employee.setSalary(value.getSalary());
                return;
            }
        }
        list.add(value);
        size++;
    }

    public Employee get(int key) {
        int index = hash(key);
        LinkedList<Employee> list = table[index];
        for (Employee employee : list) {
            if (employee.getId() == key) {
                return employee;
            }
        }
        return null;
    }

    public void remove(int key) {
        int index = hash(key);
        LinkedList<Employee> list = table[index];
        for (Employee employee : list) {
            if (employee.getId() == key) {
                list.remove(employee);
                size--;
                return;
            }
        }
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(int key) {
        return key % capacity;
    }

    public LinkedList<Employee>[] getTable() {
        return null;
    }
}
