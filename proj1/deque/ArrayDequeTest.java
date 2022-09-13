package deque;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void addAndGetTest() {
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        for (int i = 0; i < 10; ++i) {
            deq.addFirst(i);
        }
        for (int i = 0; i < deq.size(); ++i) {
            System.out.println(deq.get(i) + " ");
        }
    }
    @Test
    public void equalTest() {
        Deque<Integer> deq = new ArrayDeque<>();
        Deque<Integer> deq1 = new ArrayDeque<>();
        Deque<Integer> deq2 = new LinkedListDeque<>();
        deq.addFirst(1);
        assertFalse("different size of deque should not equal", deq.equals(deq1));
        assertTrue("different implementations of deque should equal", deq1.equals(deq2));
    }
}
