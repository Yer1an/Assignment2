import java.util.Iterator;
public class MyArrayList<T> implements MyList<T> {
    private Object[] array;
    private int size;

    MyArrayList(){
        this.array = new Object[5];
        this.size = 0;
    }
    @Override
    public void add(T item) {
        if (array.length == size) {
            buffer();
        }
        array[size++] = item;
    }
    void buffer(){
        Object[] temp =  new Object[array.length * 2];
        for(int i = 0; i < size; i++){
            temp[i] = array[i];
        }
        array = temp;
    }
    @Override
    public Object[] toArray(){
        Object[] new_array = new Object[size];
        for(int i = 0; i < size; i++){
            new_array[i] = array[i];
        }
        return new_array;
    }
    @Override
    public void set(int index, T item){
        checker(index);
        array[index] = item;
    }

    private void checker(int index) {
        if(index >= size && index < 0) {
            throw new RuntimeException("Index out of bounds");
        }
    }

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

    @Override
    public void sort(){
        for(int i = 0; i < size; i++){
            for(int j = i; j > 0 && array[j-1] > array[j]; j--){


            }
        }
    }

    @Override
    public int indexOf(Object object){
        for(int i = 0; i < size; i++){
            if(array[i] == object){
                return 1;
            }
        }
        return -1;
    }
    @Override
    public int lastIndexOf(Object object){
        for(int i = size; i >= 0; i--){
            if(array[i] == object){
                return i;
            }
        }
        return -1;
    }
    @Override
    public boolean exists(Object object){
        return indexOf(object) != -1;
    }
    @Override
    public void addFirst(T item){
        add(0, item);
    }
    @Override
    public  void addLast(T item){
        add(size, item);
    }
    @Override
    public T get(int index){
        checker(index);
        return (T) array[index];
    }
    @Override
    public T getFirst(){
        if(size == 0){
            throw new RuntimeException("ArrayList is empty");
        }
        return (T)array[0];

    }
    @Override
    public T getLast(){
        if(size == 0){
            throw new RuntimeException("ArrayList is empty");
        }
        return  (T)array[size-1];
    }
    @Override
    public void remove(int index){
        checker(index);
        for(int i = index+1; i < size; i++){
            array[i-1] = array[i];
        }
        size--;
    }
    @Override
    public void removeLast(){
        if(size == 0){
            throw new RuntimeException("Array is empty");
        }
        remove(size-1);
    }
    @Override
    public void removeFirst(){
        if(size == 0){
            throw new RuntimeException("Array is empty");
        }
        remove(0);
    }
    @Override
    public void clear(){
        array = new Object[5];
        size = 0;
    }
    @Override
    public int size(){
        return size;
    }

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
