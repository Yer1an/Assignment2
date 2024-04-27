import java.util.Iterator;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T>{
    // Inner class representing a node in the MyLinkedList
    private class MyNode{
        T  data;     // Data stored in the node
        MyNode next; // Reference to the next node
        MyNode prev; // Reference to the previous node

        // Constructor to create a node with given data
        MyNode(T data){
            this.data = data;
        }
    }

    private MyNode head; // Reference to the first node in the list
    private MyNode tail; // Reference to the last node in the list
    private int size;    // Number of elements in the list

    // Constructor to initialize an empty linked list
    public MyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Method to add an item to the end of the list
    @Override
    public void add(T item){
        MyNode newNode = new MyNode(item);
        if(tail == null){  // If list is empty
            head = newNode;
            tail = newNode;
        }else{             // If list is not empty
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // Method to set an item at a specified index
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

    // Method to add an item at a specified index
    @Override
    public void add(int index, T item){
        if(index < 0 || index > size){
            throw new RuntimeException("Out of bounds");
        }
        if(index == 0){ // if the index pointing to the first node of the list
            addFirst(item);
        }else if(index == size){ // if the index pointing to the last node of the list
            add(item);
        }else{
            MyNode current = getNode(index);
            MyNode newNode = new MyNode(item);
            newNode.prev = current.prev;
            newNode.prev.next = newNode;
            newNode.next = current;
            current.prev = newNode;
            size++;
        }
    }

    // Method to add an item to the beginning of the list
    @Override
    public void addFirst(T item){
        MyNode newNode = new MyNode(item);
        if(head == null){   // If list is empty
            head = newNode;
            tail = newNode;
        }
        else{               // If list is not empty
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // Method to add an item to the end of the list
    @Override
    public void addLast(T item){
        add(item);
    }

    // Method to get an item at a specified index
    @Override
    public T get(int index){
        MyNode newNode =  getNode(index);
        return newNode.data;
    }

    // Method to get the first item in the list
    @Override
    public T getFirst(){
        if(head == null){
            throw new RuntimeException("MyLinkedList is empty");
        }
        return head.data;
    }

    // Method to get the last item in the list
    @Override
    public T getLast(){
        if(tail == null){
            throw new RuntimeException("MyLinkedList is empty");
        }
        return tail.data;
    }

    // Method to remove an item at a specified index
    @Override
    public void remove(int index){
        MyNode newNode = getNode(index);
        if(newNode == head) {      // If the node to be removed is the first node
            removeFirst();
        }else if(newNode == tail){ // If the node to be removed is the last node
            removeLast();
        }else{                     // If the node to be removed is in the middle
            newNode.prev.next = newNode.next;
            newNode.next.prev = newNode.prev;
            size--;
        }
    }

    // Method to remove the first item in the list
    @Override
    public void removeFirst(){
        if(head == null){  // If list is empty
            throw new RuntimeException("There is nothing to remove, list is empty");
        }
        if(head == tail) { // If list has only one node
            head = null;
            tail = null;
        }else{             // If list has more than one node
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    // Method to remove the last item in the list
    @Override
    public void removeLast(){
        if(tail == null){  // If list is empty
            throw new RuntimeException("There is nothing to remove, list is empty");
        }
        if(head == tail){ // If list has only one node
            removeFirst();
        }else{            // If list has more than one node
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    // Method to sort the list (using bubble sort algorithm)
    @Override
    public void sort(){
        MyNode current = head;
        MyNode index = null;
        if(head == null) {  // If list is empty
            return;
        }else{
            while(current != null){
                index = current.next;

                while(index != null){
                    if(current.data.compareTo(index.data) > 0){
                        T temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }

    }

    // Method to find the index of a certain object
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

    // Method to find the last index of a certain object
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

    // Method to check if an object exists in the list
    @Override
    public boolean exists(Object object){
        return indexOf(object) != -1;
    }

    // Method to convert the list to an array
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

    // Method to clear the list
    @Override
    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    // Method to get the size of the list
    @Override
    public int size(){
        return size;
    }

    // Method to create an iterator for the list
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

    // Method to get the node at a specified index
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
