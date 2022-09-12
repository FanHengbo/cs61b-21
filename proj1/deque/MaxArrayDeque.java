package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> {
    public deque.ArrayDeque<T> deq;
    public Comparator<T> comparator;
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
    public void addFirst(T item) {
        deq.addFirst(item);
    }
    public void addLast(T item) {
        deq.addLast(item);
    }
    public boolean isEmpty() {
        return deq.isEmpty();
    }
    public int size() {
        return deq.size();
    }
    public void printDeque() {
        deq.printDeque();
    }
    public T removeFirst() {
        return deq.removeFirst();
    }
    public T removeLast() {
        return deq.removeLast();
    }
    public T get(int index) {
        return deq.get(index);
    }
}
