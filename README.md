# Assignment 2
This repository contains custom implementations of various data structures in Java. The implemented data structures include:

1. MyArrayList
2. MyLinkedList
3. MyQueue
4. MyStack
5. MyMinHeap

### MyArrayList

- Implements the `MyList` interface, similar to `ArrayList`.
- Stores elements in a dynamic array, resizing as needed when elements are added or removed.
- Supported operations: adding, removing, getting, sorting elements.

### MyLinkedList

- Implements the `MyList` interface, similar to `LinkedList`.
- Stores elements in a doubly linked list structure.
- Supported operations: adding, removing, getting, sorting elements.
- Provides an iterator for traversing the elements.

### MyQueue

- Implements a queue data structure using the `MyLinkedList`, because it's more convenient to delete/insert elements.
- Supported operations: enqueue, dequeue, peek, and checking for emptiness.
- Adheres to the principle FIFO (First-In-First-Out)

### MyStack

- Implements a stack data structure using the `MyLinkedList`, because it's more convenient to delete/insert elements.
- Supported operations: push, pop, peek, and checking for emptiness.
- Adheres to the principle LIFO (Last-In-First-Out).

### MyMinHeap

- Implements a min-heap data structure using the `MyArrayList`, because it's convenient to have direct access to the elements.
- Supported operations: insertion, extraction of the minimum element, peeking at the minimum element, and checking for emptiness.
- Adheres to the principle of the Min-Heap.


## Testing
 - In order to test MyLinkedList and MyArrayList classes, I have searched examples in the internet and 
most attractive was the usage of JUnits test, therefore I've created MyArrayListTest and MyLinkedListTest public classes
which contains of test of the methods of each class. Then, in `Main.java` I'm checking do the classes passes all test, according
to it there can be to outcome `passed` or `failed`;