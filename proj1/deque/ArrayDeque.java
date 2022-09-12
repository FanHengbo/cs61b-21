package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T> {
    private static final int RFACTOR = 2;
    private T[] items;
    private int size;
    private int front;
    private int rear;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        front = -1;
        rear = 0;
        size = 0;
    }
    public boolean equals(Object o) {
        return o instanceof Deque<?>;
    }
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                return get(currentIndex++);
            }
        };
        return it;
    }
    @Override
    public void addFirst(T item) {
        if (isFull()) {
            resize(size * RFACTOR);
        } else if (front == -1) {
            items[0] = item;
            front = 0;
            rear = 0;
            ++size;
            return;
        }
        front = nextElement(front);
        items[front] = item;
        ++size;
    }
    @Override
    public void addLast(T item) {
        if (isFull()) {
            resize(size * RFACTOR);
        }
        ++rear;
        items[rear] = item;
        ++size;
    }
    private void resize(int newSize) {
        T[] newArray = (T[]) new Object[newSize];
        if (front < rear) {
            System.arraycopy(items, front, newArray, 0, size);
            if (newSize < items.length) {
                // When we need to shrink the size of items
                front = 0;
                rear = size - 1;
            }
        } else {
            System.arraycopy(items, 0, newArray, 0, rear + 1);
            System.arraycopy(items, front, newArray, newSize - size + rear + 1, size - rear - 1);
            front = newSize - size + rear + 1;
        }
        items = newArray;
    }
    private boolean isFull() {
        return (front == 0 && rear == items.length - 1 || front == rear + 1);
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void printDeque() {
        if (isEmpty()) {
            return;
        }
        for (int i = front; i != rear + 1;) {
            System.out.print(items[i] + " ");
            i = nextElement(i);
        }
        System.out.println();
    }
    @Override
    public T removeFirst() {
        double fraction = (double) size / (double) items.length;
        if (isEmpty()) {
            return null;
        }
        if (fraction < 0.25 && items.length > 8) {
            // Need to shrink
            resize(items.length / RFACTOR);
        }
        T toRemove = items[front];
        items[front] = null;

        front = nextElement(front);
        --size;
        return toRemove;
    }
    private int nextElement(int cur) {
        return (cur + 1) % items.length;
    }
    private int prevElement(int cur) {
        return (cur + items.length - 1) % items.length;
    }
    @Override
    public T removeLast() {
        double fraction = (double) size / (double) items.length;
        if (isEmpty()) {
            return null;
        }
        if (fraction < 0.25 && items.length > 8) {
            // Need to shrink
            resize(items.length / RFACTOR);
        }
        T toRemove = items[rear];
        items[rear] = null;
        rear = prevElement(rear);
        --size;
        return toRemove;
    }
    @Override
    public T get(int index) {
        if (isEmpty() || index > size - 1) {
            return null;
        }
        return items[(index + front) % items.length];
    }
}
