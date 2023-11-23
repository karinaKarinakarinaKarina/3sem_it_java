package collections_lab;

public class stack_use {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(5);
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        System.out.println("Верхний элемент стека: " + stack.peek()); // Верхний элемент стека: 3
        
        int poppedItem = stack.pop();
        System.out.println("Удаленный элемент: " + poppedItem); // Удаленный элемент: 3
        
        System.out.println("Верхний элемент стека: " + stack.peek()); // Верхний элемент стека: 2
    }
}
