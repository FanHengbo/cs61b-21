package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private deque.ArrayDeque<T> deq;
    private Comparator<T> comparator;
    public MaxArrayDeque(Comparator<T> c) {
        deq = new ArrayDeque<>();
        comparator = c;
    }
    public T max() {
        if (deq.isEmpty()) {
            return null;
        }
        T maxItem = deq.get(0);
        for (int i = 0; i < deq.size(); i++) {
            if (comparator.compare(maxItem, deq.get(i)) <= 0) {
                maxItem = deq.get(i);
            }
        }
        return maxItem;
    }
    public T max(Comparator<T> c) {
        if (deq.isEmpty()) {
            return null;
        }
        T maxItem = deq.get(0);
        for (int i = 0; i < deq.size(); i++) {
            if (c.compare(maxItem, deq.get(i)) <= 0) {
                maxItem = deq.get(i);
            }
        }
        return maxItem;
    }
}

