public class Main {
    public static void main(String[] args) {
        testMyStack();
        testMyQueue();
    }
    private static void testMyStack() {
        System.out.println("Testing MyStack:");

        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Test peek
        assert stack.peek() == 3;

        // Test pop
        assert stack.pop() == 3;
        assert stack.pop() == 2;
        assert stack.pop() == 1;

        // Test isEmpty
        assert stack.isEmpty();

        System.out.println("MyStack tests passed.");
    }

    private static void testMyQueue() {
        System.out.println("Testing MyQueue:");

        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Test peek
        assert queue.peek() == 1;

        // Test dequeue
        assert queue.dequeue() == 1;
        assert queue.dequeue() == 2;
        assert queue.dequeue() == 3;

        // Test isEmpty
        assert queue.isEmpty();

        System.out.println("MyQueue tests passed.");
    }
}