package deque;

import org.junit.Test;

public class ArrayDequeTest {
    @Test
    public void addAndGetTest() {
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        for (int i = 0; i < 10; ++i) {
            deq.addLast(i);
        }
        for (int i = 0; i < deq.size(); ++i) {
            System.out.println(deq.get(i) + " ");
        }
    }
}
