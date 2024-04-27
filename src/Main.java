import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class Main {
    public static void main(String[] args) {
        //Testing MyArrayList
        System.out.println("Test of MyArrayList: " +  ((JUnitCore.runClasses(MyArrayListTest.class).wasSuccessful())? "passed" : "failed"));
        //Testing MyLinkedList
        System.out.println("Test of MyLinkedList: " +  ((JUnitCore.runClasses(MyLinkedListTest.class).wasSuccessful())? "passed" : "failed"));

    }
}