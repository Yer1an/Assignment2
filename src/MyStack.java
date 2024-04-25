import java.util.Iterator;
public class MyStack<T>{
    private MyLinkedList stack;

    public MyStack(){
        this.stack = new MyLinkedList<>();
    }

    public void push(T item){
        stack.addLast(item);
    }

    public T peek(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        return (T)stack.getLast();
    }

    public boolean isEmpty(){
        return stack.size() == 0;
    }
    public T pop(){
        if(isEmpty()){
            throw new RuntimeException("There is nothing to remove stack is empty");
        }
        T item = peek();
        stack.removeLast();
        return item;
    }

    public int size(){
        return stack.size();
    }
}
