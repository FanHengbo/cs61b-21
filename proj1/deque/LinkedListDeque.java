package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T> {
    private Node sentinel;
    private int size;

    private class Node {
        private T item;
        private Node next;
        private Node prev;
        Node(T i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }
    public boolean equals(Object o) {
        return o instanceof Deque<?> && this.equals(o);
    }
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
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
        Node temp = sentinel.next;
        if (isEmpty()) {
            sentinel.next = new Node(item, sentinel, sentinel);
            sentinel.prev = sentinel.next;
        } else {
            sentinel.next = new Node(item, sentinel, temp);
            temp.prev = sentinel.next;
        }
        ++size;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void addLast(T item) {
        Node lastItem = sentinel.prev;
        if (isEmpty()) {
            addFirst(item);
        } else {
            lastItem.next = new Node(item, lastItem, sentinel);
            sentinel.prev = lastItem.next;
            ++size;
        }
    }
    @Override
    public void printDeque() {
        for (Node tran = sentinel.next; tran != sentinel; tran = tran.next) {
            System.out.print(tran.item + " ");
        }
        System.out.println();
    }
    @Override
    public T removeFirst() {
        Node toRemove = sentinel.next;
        if (isEmpty()) {
            return null;
        }
        sentinel.next = toRemove.next;
        toRemove.next.prev = sentinel;
        toRemove.next = null;
        toRemove.prev = null;
        --size;
        return toRemove.item;
    }
    @Override
    public T removeLast() {
        Node toRemove = sentinel.prev;
        if (isEmpty()) {
            return null;
        }
        sentinel.prev = toRemove.prev;
        toRemove.prev.next = sentinel;
        toRemove.next = null;
        toRemove.prev = null;
        --size;
        return toRemove.item;
    }
    @Override
    public T get(int index) {
        int i = 0;
        Node tran = sentinel.next;
        if (index > size - 1 || isEmpty()) {
            return null;
        }
        while (i < index) {
            tran = tran.next;
            ++i;
        }
        return tran.item;
    }
    public T getRecursive(int index) {
        if (index > size - 1 || isEmpty()) {
            return null;
        }
        return getRecursive(sentinel.next, index);
    }
    private T getRecursive(Node n, int index) {
        if (index == 0) {
            return n.item;
        }
        return getRecursive(n.next, index - 1);
    }
}
