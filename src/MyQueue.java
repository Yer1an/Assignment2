public class MyQueue<T extends Comparable<T>>{
    private MyLinkedList queue; // Internal representation of the queue using a linked list

    // Constructor to initialize an empty queue
    public MyQueue(){
        queue = new MyLinkedList<>();
    }

    // Method to check if the queue is empty
    public boolean isEmpty(){
        return queue.size() == 0; // Check if the size of the queue is zero
    }

    // Method to add an item to the end of the queue
    public void enqueue(T item){
        queue.addLast(item); // Add the item to the end of the linked list
    }

    // Method to remove and return the item at the front of the queue
    public T dequeue(){
        if(isEmpty()){
            throw new RuntimeException("MyQueue is empty"); // Throw an exception if the queue is empty
        }
        T item = (T)queue.getFirst(); // Get the first item in the queue
        queue.removeFirst(); // Remove the first item from the queue
        return item; // Return the removed item
    }

    // Method to return the item at the front of the queue without removing it
    public T peek(){
        if(isEmpty()){
            throw new RuntimeException("MyQueue is empty"); // Throw an exception if the queue is empty
        }
        return (T)queue.getFirst(); // Return the first item in the queue
    }

    // Method to get the size of the queue
    public int size(){
        return queue.size(); // Return the size of the queue
    }
}
