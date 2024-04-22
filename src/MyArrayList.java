public class MyArrayList<T> implements MyList<T> {
    private T array[];
    private int size;

    MyArrayList(){
        array = (T[]) new Object[5];
        size = 0;
    }

    public void add(T item) {
        if (array.length == size+1) {
            buffer();
        }
        array[size++] = item;
    }
    void buffer(){
        T temp[] = (T[]) new Object[array.length * 2];
        for(int i = 0; i < array.length; i++){
            temp[i] = array[i];
        }
        array = temp;
    }

    public void set(int index, T item){
        checker(index);
        array[index] = item;
    }

    private void checker(int index) {
        if(index >= size && index < 0) {
            throw new RuntimeException("Index out of bounds");
        }
    }

    // Can we add to some index, which is strictly bigger the size?
    public void add(int index,T item){
        if(index > size){
            throw new RuntimeException("Out of bounds");
        }
        if (array.length == size+1) {
            buffer();
        }
        checker_forAddition(index);
        T lost = array[index];
        array[index] = item;
        size++;
        for(int i = index+1; i < size; i++){
            T temp = array[i];
            array[i] = lost;
            lost = temp;
        }
    }

    private void checker_forAddition(int index){
        if(index > size){
            throw new RuntimeException("Index way too out of bounds");
        }
    }

    public void sort(){
        for(int i = 0; i < size; i++){
            for(int j = i; j > 0 && array[j-1] > array[j]; j--){

            }
        }
    }

    public int indexOf(Object object){
        T item  = (T) object;
        int index = -1;
        for(int i = 0; i < size; i++){
            if(array[i] == item){
                index = i;
                break;
            }
        }
        if(index == -1){
            throw new RuntimeException("There is no such elements in the MyArrayList");
        }
        return index;
    }

    public int lastIndexOf(Object object){
        T item = (T) object;
        int index = -1;
        for(int i = size; i >= 0; i--){
            if(array[i] == item){
                index = i;
                break;
            }
        }
        if(index == -1){
            throw new RuntimeException("There is no such elements in the MyArrayList");
        }
        return index;
    }

    public boolean exists(Object object){
        T item = (T) object;
        for(T i : array){
            if(i == item){
                return true;
            }
        }
        return false;
    }

    public void addFirst(T item){
        if(size + 1 == array.length){
            buffer();
        }
        T lost = array[0];
        array[0] = item;
        size++;
        for(int i = 1; i < size; i++){
            T temp = array[i];
            array[i] = lost;
            lost = temp;
        }
    }

    public  void addLast(T item){
        if(size + 1 == array.length){
            buffer();
        }
        array[size++] = item;
    }
    public T get(int index){
        checker(index);
        return array[index];
    }
    public T getFirst(){
        return array[0];
    }
    public T getLast(){
        return array[size-1];
    }

    public void remove(int index){
        checker(index);
        for(int i = index+1; i < size; i++){
            array[i-1] = array[i];
        }
        size--;
    }
    public void clear(){
        array = (T[]) new Object[5];
        size = 0;
    }
    public int size(){
        return size;
    }


}
