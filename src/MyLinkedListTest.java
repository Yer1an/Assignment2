import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
public class MyLinkedListTest {
    @Test
    public void add_get() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    @Test
    public void set() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        list.set(1, "D");
        assertEquals("D", list.get(1));
    }

    @Test
    public void add_index() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        list.add(1, 15);
        assertEquals(15, list.get(1));

        list.add(4, 555);
        assertEquals(555, list.get(4));
    }

    @Test
    public void addFirst_Last() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addFirst(10);
        list.addFirst(20);
        list.addLast(30);

        assertEquals(3, list.size());
        assertEquals(20, list.getFirst());
        assertEquals(30, list.getLast());
    }

    @Test
    public void remove() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        list.remove(1);
        assertEquals(2, list.size());
        assertEquals("C", list.get(1));
    }

    @Test
    public void removeFirst_Last() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        list.removeFirst();
        list.removeLast();
        assertEquals(1, list.size());
        assertEquals("B", list.get(0));
    }

    @Test
    public void sort() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(3);
        list.add(1);
        list.add(2);

        list.sort();
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    public void indexOf() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals(1, list.indexOf("B"));
    }

    @Test
    public void lastIndexOf() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("A");
        list.add("B");
        list.add("A");

        assertEquals(2, list.lastIndexOf("A"));
    }

    @Test
    public void exists() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertTrue(list.exists(2));
        assertFalse(list.exists(4));
    }

    @Test
    public void toArray() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Object[] array = list.toArray();
        assertEquals(3, array.length);
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
        assertEquals(3, array[2]);
    }

    @Test
    public void clear() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.size());

        list.clear();
        assertEquals(0, list.size());
        assertEquals(0,list.size());
    }
    @Test
    public void size() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.size());
    }
}