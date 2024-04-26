public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap;

    public MyMinHeap(){
        this.heap = new MyArrayList<>();
    }

    public void insert(T item){
        heap.add(item);
        bubbleUp(heap.size()-1);
    }

    private void bubbleUp(int index){
        while(index > 0){
            int parent = (index-1)/2;
            if(heap.get(index).compareTo(heap.get(parent)) < 0){
                swap(index, parent);
                index = parent;
            }else{
                break;
            }
        }
    }

    public T extractMin(){
        if(isEmpty()){
            throw new RuntimeException("MyMinHeap is empty");
        }
        T min = heap.get(0);
        T last = heap.getLast();
        heap.set(0, last);
        heap.removeLast();
        bubbleDown(0);
        return min;
    }

    private void bubbleDown(int index){
        int leftChild = 2*index +1;
        int rightChild = 2*index + 2;
        int min = index;

        if (leftChild < heap.size() && heap.get(leftChild).compareTo(heap.get(min)) < 0) {
            min = leftChild;
        }
        if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(min)) < 0) {
            min = rightChild;
        }

        if(min != index){
            swap(index, min);
            bubbleDown(min);
        }
    }

    public T peekMin(){
        if(isEmpty()){
            throw new RuntimeException("Heap is empty");
        }
        return heap.get(0);
    }

    public boolean isEmpty(){
        return heap.size() == 0;
    }

    public int size(){
        return heap.size();
    }
    private void swap(int a, int b){
        T temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);

    }

}
