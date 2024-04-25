import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T>{
    private class MyNode{
        T  data;
        MyNode next;
        MyNode prev;

        MyNode(T data){
            this.data = data;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void add(T item){
        MyNode newNode = new MyNode(item);
        if(tail == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    @Override
    public void set(int index,T item){
        if (index < 0 || index >= size) {
            throw new RuntimeException("Out of Bounds");
        }
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = item;
    }
    @Override
    public void add(int index, T item){
        if(index < 0 || index > size){
            throw new RuntimeException("Out of bounds");
        }
        if(index == 0){
            addFirst(item);
        }else if(index == size){
            add(item);
        }else{
            MyNode current = getNode(index);
            MyNode newNode = new MyNode(item);
            newNode.prev = current.prev;
            newNode.prev.next = current;
            newNode.next = current;
            current.prev = newNode;
            size++;
        }
    }

    @Override
    public void addFirst(T item){
        MyNode newNode = new MyNode(item);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    @Override
    public void addLast(T item){
        add(item);
    }
    @Override
    public T get(int index){
        MyNode newNode =  getNode(index);
        return newNode.data;
    }
    @Override
    public T getFirst(){
        if(head == null){
            throw new RuntimeException("MyLinkedList is empty");
        }
        return head.data;
    }

    @Override
    public T getLast(){
        if(tail == null){
            throw new RuntimeException("MyLinkedList is empty");
        }
        return tail.data;
    }

    @Override
    public void remove(int index){
        MyNode newNode = getNode(index);
        if(newNode == head) {
            removeFirst();
        }else if(newNode == tail){
            removeLast();
        }else{
            newNode.prev.next = newNode.next;
            newNode.next.prev = newNode.prev;
            size--;
        }
    }

    @Override
    public void removeFirst(){
        if(head == null){
            throw new RuntimeException("There is nothing to remove, list is empty");
        }
        if(head == tail) {
            head = null;
            tail = null;
        }else{
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    @Override
    public void removeLast(){
        if(tail == null){
            throw new RuntimeException("There is nothing to remove, list is empty");
        }
        if(head == tail){
            removeFirst();
        }else{
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }
    @Override
    public void sort(){

    }
    @Override
    public int indexOf(Object object){
        int index = 0;
        MyNode current = head;
        while(current != null){
            if (current.data.equals(object)){
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object){
        int index = size - 1;
        MyNode current = tail;
        while(current != null){
            if(current.data.equals(object)){
                return index;
            }
            current = current.prev;
            index--;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object){
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray(){
        Object[] array = new Object[size];
        MyNode current = head;
        int i = 0;
        while(current != null){
            array[i] = current.data;
            current = current.next;
            i++;
        }
        return array;
    }

    @Override
    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public Iterator<T> iterator(){
        return new Iterator<T>() {
            private MyNode current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }
            @Override
            public T next() {
                if(!hasNext()){
                    throw new RuntimeException("No more elements in the list");
                }
                T data = current.data;
                current = current.next;
                return data;

            }
        };
    }

    private MyNode getNode(int index){
        if(index < 0 || index >= size){
            throw new RuntimeException("Out of bounds");
        }
        MyNode current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current;
    }


}
