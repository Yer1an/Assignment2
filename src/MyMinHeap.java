public class MyMinHeap<T extends Comparable<T>> {
    //As a field I decided to use MyArrayList because of the ability to directly get access the needed element
    private MyArrayList<T> heap;

    // Constructor to initialize MyMinHeap
    public MyMinHeap(){
        this.heap = new MyArrayList<>();
    }

    // Method to insert an item into the MyMinHeap
    public void insert(T item){
        heap.add(item); // Add the item to the end of the heap
        bubbleUp(heap.size()-1); // Restore MyMinHeap sorting the newly added item
    }

    // Helper method to restore the heap property by bubbling up
    private void bubbleUp(int index){
        while(index > 0){
            int parent = (index-1)/2; // Calculate the index of the parent node
            // If the current node is smaller than its parent, swap them
            if(heap.get(index).compareTo(heap.get(parent)) < 0){
                swap(index, parent);
                index = parent; // Move to the parent node
            }else{
                break; // Stop if the heap property is restored
            }
        }
    }

    // Method to extract the minimum element from the min-heap
    public T extractMin(){
        if(isEmpty()){
            throw new RuntimeException("MyMinHeap is empty");
        }
        T min = heap.get(0); // Get the minimum element (root of the heap)
        T last = heap.getLast(); // Get the last element in the heap
        heap.set(0, last); // Replace the root with the last element
        heap.removeLast(); // Remove the last element from the heap
        bubbleDown(0); // Restore heap property by bubbling down the root
        return min; // Return the minimum element
    }

    // Helper method to restore the heap property by bubbling down
    private void bubbleDown(int index){
        int leftChild = 2*index + 1; // Calculate the index of the left child
        int rightChild = 2*index + 2; // Calculate the index of the right child
        int min = index; // Assume the current node is the minimum

        // Find the minimum of the current node, left child, and right child
        if (leftChild < heap.size() && heap.get(leftChild).compareTo(heap.get(min)) < 0) {
            min = leftChild;
        }
        if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(min)) < 0) {
            min = rightChild;
        }

        // If the current node is not the minimum, swap it with the minimum child and continue bubbling down
        if(min != index){
            swap(index, min);
            bubbleDown(min);
        }
    }

    // Method to peek at the minimum element of the min-heap without removing it
    public T peekMin(){
        if(isEmpty()){
            throw new RuntimeException("Heap is empty");
        }
        return heap.get(0); // Return the root of the heap (minimum element)
    }

    // Method to check if the min-heap is empty
    public boolean isEmpty(){
        return heap.size() == 0; // Check if the size of the heap is zero
    }

    // Method to get the size of the min-heap
    public int size(){
        return heap.size(); // Return the size of the heap
    }

    // Helper method to swap two elements in the min-heap
    private void swap(int a, int b){
        T temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
    }
}
