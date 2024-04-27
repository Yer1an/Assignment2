import java.util.Iterator;
import java.lang.Comparable;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    //As a field of the class there are used array of Object and integer size, which stores the length of the array
    private Object[] array;
    private int size;


    // Constructor. Initializes the array with a default size of 5.
    MyArrayList(){
        this.array = new Object[5];
        this.size = 0;
    }

    // Method to add an item to the list
    @Override
    public void add(T item) {
        if (array.length == size) {
            buffer();
        }
        array[size++] = item;
    }

    // Method to resize the array if it's full.
    void buffer(){
        Object[] temp =  new Object[array.length * 2];
        for(int i = 0; i < size; i++){
            temp[i] = array[i];
        }
        array = temp;
    }

    // Method to convert the list to an array.
    @Override
    public Object[] toArray(){
        Object[] new_array = new Object[size];
        for(int i = 0; i < size; i++){
            new_array[i] = array[i];
        }
        return new_array;
    }

    // Method to set an item at a specified index.
    @Override
    public void set(int index, T item){
        checker(index);
        array[index] = item;
    }

    // Method to check if the index is within bounds.
    private void checker(int index) {
        if(index >= size || index < 0) {
            throw new RuntimeException("Index out of bounds");
        }
    }

    // Method to add an item at a specified index.
    @Override
    public void add(int index,T item){
        if(index > size || index < 0 ){
            throw new RuntimeException("Out of bounds");
        }
        if (array.length == size) {
            buffer();
        }
        Object lost = array[index];
        array[index] = item;
        size++;
        for(int i = index+1; i < size; i++){
            Object temp = array[i];
            array[i] = lost;
            lost = temp;
        }
    }

    // Method to compare two elements at specified indices.
    public int compare(int index1, int index2) {
        if (index1 < 0 || index1 >= size || index2 < 0 || index2 >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        T element1 = (T) array[index1];
        T element2 = (T) array[index2];
        return element1.compareTo(element2);
    }

    // Method to sort the list.
    @Override
    public void sort(){
        for(int i = 0; i < size; i++){
            for(int j = i; j > 0 && compare(j-1, j) > 0; j--){
                swap(j-1 , j);
            }
        }
    }

    // Method to swap two elements at specified indices.
    private void swap(int index1, int index2){
        Object temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    // Method to find the index of a specified object.
    @Override
    public int indexOf(Object object){
        for(int i = 0; i < size; i++){
            if(array[i].equals(object)){
                return i;
            }
        }
        return -1;
    }

    // Method to find the last index of a specified object.
    @Override
    public int lastIndexOf(Object object){
        for(int i = size-1; i >= 0; i--){
            if(array[i] == object){
                return i;
            }
        }
        return -1;
    }

    // Method to check if an object exists in the list.
    @Override
    public boolean exists(Object object){
        return indexOf(object) != -1;
    }

    // Method to add an item to the beginning of the list.
    @Override
    public void addFirst(T item){
        add(0, item);
    }

    // Method to add an item to the end of the list.
    @Override
    public  void addLast(T item){
        add(size, item);
    }

    // Method to get an item at a specified index.
    @Override
    public T get(int index){
        checker(index);
        return (T) array[index];
    }

    // Method to get the first item in the list.
    @Override
    public T getFirst(){
        if(size == 0){
            throw new RuntimeException("ArrayList is empty");
        }
        return (T)array[0];

    }

    // Method to get the last item in the list.
    @Override
    public T getLast(){
        if(size == 0){
            throw new RuntimeException("ArrayList is empty");
        }
        return  (T)array[size-1];
    }

    // Method to remove an item at a specified index.
    @Override
    public void remove(int index){
        checker(index);
        for(int i = index+1; i < size; i++){
            array[i-1] = array[i];
        }
        size--;
    }

    // Method to remove the last item in the list.
    @Override
    public void removeLast(){
        if(size == 0){
            throw new RuntimeException("Array is empty");
        }
        remove(size-1);
    }

    // Method to remove the first item in the list.
    @Override
    public void removeFirst(){
        if(size == 0){
            throw new RuntimeException("Array is empty");
        }
        remove(0);
    }

    // Method to clear the list.
    @Override
    public void clear(){
        array = new Object[5];
        size = 0;
    }

    // Method to get the size of the list.
    @Override
    public int size(){
        return size;
    }

    // Iterator implementation to iterate over the elements of the list.
    @Override
    public Iterator<T> iterator(){
        return new Iterator<T>() {
            private int current = 0;
            @Override
            public boolean hasNext() {
                return current < size;
            }
            @Override
            public T next() {
                return (T) array[current++];
            }
        };
    }

}
