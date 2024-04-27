import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class MyArrayListTest {
    @Test
    public void add() {
        var myArrayList = new MyArrayList<Integer>();
        myArrayList.add(5);

        assertEquals(1,myArrayList.size());
        assertEquals(5,myArrayList.getFirst());
        assertEquals(5, myArrayList.getLast());
    }

    @Test
    public void add_index() {
        var myArrayList = new MyArrayList<Integer>();
        myArrayList.add(5);
        myArrayList.add(4);
        myArrayList.add(3);
        myArrayList.add(2);

        assertEquals(4,myArrayList.size());
        assertEquals(3,myArrayList.get(2));
        assertEquals(5,myArrayList.getFirst());
        assertEquals(2, myArrayList.getLast());

        myArrayList.add(2, 54);
        assertEquals(54, myArrayList.get(2));
        assertEquals(3, myArrayList.get(3));

        myArrayList.add(5, 123);
        assertEquals(123, myArrayList.get(5));
    }

    @Test
    public void toArray() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(4);
        myArrayList.add(2);
        myArrayList.add(6);
        Object[] temp = {4,2,6};


        assertArrayEquals(temp , myArrayList.toArray());
    }

    @Test
    public void set() {
        MyArrayList<Double> myArrayList = new MyArrayList<>();
        myArrayList.add(5.5);
        myArrayList.add(2.2);
        myArrayList.add(3.6);
        myArrayList.add(5.11);

        myArrayList.set(0, 323.212);
        assertEquals(323.212, myArrayList.get(0));
    }

    @Test
    public void sort() {
        MyArrayList<Double> myArrayList = new MyArrayList<>();
        myArrayList.add(3.2);
        myArrayList.add(2.1);
        myArrayList.add(4.6);
        myArrayList.add(5.7);

        Object[] temp = {2.1 , 3.2 , 4.6, 5.7};
        myArrayList.sort();
        assertArrayEquals(temp , myArrayList.toArray());
    }

    @Test
    public void indexOf() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(52);
        myArrayList.add(3);
        myArrayList.add(76);
        myArrayList.add(5);

        assertEquals(2, myArrayList.indexOf(3));
        assertEquals(-1, myArrayList.indexOf(43));
    }


    @Test
    public void lastIndexOf() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(76);
        myArrayList.add(5);

        assertEquals(1, myArrayList.lastIndexOf(1));
        assertEquals(-1, myArrayList.lastIndexOf(4));
    }
    @Test
    public void exists() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(76);
        myArrayList.add(5);

        assertTrue(myArrayList.exists(76));
        assertFalse(myArrayList.exists(45));
    }

    @Test
    public void addFirst() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(76);
        myArrayList.add(5);

        myArrayList.addFirst(332);
        assertEquals(332, myArrayList.getFirst());
        assertEquals(332, myArrayList.get(0));
        assertEquals(6, myArrayList.size());

        assertEquals(1,  myArrayList.get(1));
    }

    @Test
    public void addLast() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(76);

        myArrayList.addLast(123);
        myArrayList.addLast(333);

        assertEquals(6, myArrayList.size());
        assertEquals(333, myArrayList.getLast());
        assertEquals(333, myArrayList.get(5));
        assertEquals(123, myArrayList.get(4));
    }

    @Test
    public void get() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(76);
        myArrayList.add(5);

        assertEquals(1, myArrayList.get(0));
        assertEquals(2, myArrayList.get(1));
        assertEquals(3, myArrayList.get(2));
        assertEquals(76, myArrayList.get(3));
        assertEquals(5, myArrayList.get(4));
    }

    @Test
    public void getFirst() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(76);
        myArrayList.add(5);

        assertEquals(1, myArrayList.getFirst());
        myArrayList.addFirst(5);
        assertEquals(5, myArrayList.getFirst());
    }

    @Test
    public void getLast() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(76);
        myArrayList.add(5);

        assertEquals(5, myArrayList.getLast());
        myArrayList.addLast(654);
        assertEquals(654, myArrayList.getLast());
    }

    @Test
    public void remove() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);

        myArrayList.remove(0);
        assertEquals(2, myArrayList.size());
        assertEquals(2, myArrayList.getFirst());
        assertEquals(3, myArrayList.getLast());
    }

    @Test
    public void removeLast() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);

        myArrayList.removeLast();
        assertEquals(2, myArrayList.size());
        assertEquals(2, myArrayList.getLast());
    }

    @Test
    public void removeFirst() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);

        myArrayList.removeFirst();
        assertEquals(2, myArrayList.size());
        assertEquals(2, myArrayList.getFirst());
    }

    @Test
    public void clear() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);

        myArrayList.clear();
        assertEquals(0, myArrayList.size());
    }
    @Test
    public void size() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);

        assertEquals(3, myArrayList.size());

        myArrayList.add(4);
        myArrayList.add(5);
        assertEquals(5, myArrayList.size());
    }
}