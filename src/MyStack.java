import java.util.Iterator;

public class MyStack<T extends Comparable<T>>{
    private MyLinkedList stack; // Internal representation of the stack using a linked list

    // Constructor to initialize an empty stack
    public MyStack(){
        this.stack = new MyLinkedList<>();
    }

    // Method to push an item onto the top of the stack
    public void push(T item){
        stack.addLast(item); // Add the item to the end of the linked list
    }

    // Method to peek at the item on the top of the stack without removing it
    public T peek(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty"); // Throw an exception if the stack is empty
        }
        return (T)stack.getLast(); // Return the last item in the linked list (top of the stack)
    }

    // Method to check if the stack is empty
    public boolean isEmpty(){
        return stack.size() == 0; // Check if the size of the stack is zero
    }

    // Method to pop the item from the top of the stack and return it
    public T pop(){
        if(isEmpty()){
            throw new RuntimeException("There is nothing to remove stack is empty"); // Throw an exception if the stack is empty
        }
        T item = peek(); // Peek at the top item of the stack
        stack.removeLast(); // Remove the last item from the linked list (top of the stack)
        return item; // Return the removed item
    }

    // Method to get the size of the stack
    public int size(){
        return stack.size(); // Return the size of the stack
    }
}
