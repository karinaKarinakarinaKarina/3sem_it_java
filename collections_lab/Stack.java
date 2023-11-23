package collections_lab;

public class Stack<T> {
    private int top; // индекс верхнего элемента стека
    private T[] stackArray; // массив, используемый для хранения элементов стека

    // Конструктор класса Stack
    public Stack(int capacity) {
        stackArray = (T[]) new Object[capacity]; // создаем новый массив заданной длины
        top = -1; // при создании стека индекс верхнего элемента инициализируется значением -1
    }

    // Метод push - добавляет элемент в стек
    public void push(T item) {
        if (top == stackArray.length - 1) {
            System.out.println("Стек полон. Невозможно добавить элемент.");
            return;
        }
        
        stackArray[++top] = item; // инкрементируем top и добавляем элемент в массив
    }

    // Метод pop - удаляет и возвращает элемент из стека
    public T pop() {
        if (top == -1) {
            System.out.println("Стек пуст. Невозможно удалить элемент.");
            return null;
        }
        
        T item = stackArray[top--]; // получаем элемент из массива и декрементируем top
        return item;
    }

    // Метод peek - возвращает верхний элемент стека без его удаления
    public T peek() {
        if (top == -1) {
            System.out.println("Стек пуст.");
            return null;
        }
        
        return stackArray[top]; // возвращаем верхний элемент стека
    }
}
