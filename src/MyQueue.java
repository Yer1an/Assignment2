public class MyQueue<T>{
    private MyLinkedList queue;

    public MyQueue(){
        queue = new MyLinkedList<>();
    }

    public boolean isEmpty(){
        return queue.size() == 0;
    }

    public void enqueue(T item){
        queue.addLast(item);
    }
    public T dequeue(){
        if(isEmpty()){
            throw new RuntimeException("MyQueue is empty");
        }
        T item = (T)queue.getFirst();
        queue.removeFirst();
        return item;
    }

    public T peek(){
        if(isEmpty()){
            throw new RuntimeException("MyQueue is empty");
        }
        return (T)queue.getFirst();
    }
    public int size(){
        return queue.size();
    }


}
