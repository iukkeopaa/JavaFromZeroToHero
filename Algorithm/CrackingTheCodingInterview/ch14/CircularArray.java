package CrackingTheCodingInterview.ch14;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularArray<T> implements Iterable<T> {
    private T[] items;
    private int head = 0;

    public CircularArray(int size) {
        items = (T[]) new Object[size];
    }

    private int convert(int index) {
        if (index < 0) {
            index += items.length;
        }
        return (head + index) % items.length;
    }

    public void rotate(int shiftRight) {
        head = convert(shiftRight);
    }

    public T get(int i) {
        if (i < 0 || i >= items.length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return items[convert(i)];
    }

    public void set(int i, T item) {
        items[convert(i)] = item;
    }

    @Override
    public Iterator<T> iterator() {
        return new CircularArrayIterator();
    }

    private class CircularArrayIterator implements Iterator<T> {
        private int _current = -1;

        @Override
        public boolean hasNext() {
            return _current < items.length - 1;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            _current++;
            return items[convert(_current)];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove is not supported");
        }
    }

    public static void main(String[] args) {
        CircularArray<Integer> circularArray = new CircularArray<>(5);
        for (int i = 0; i < 5; i++) {
            circularArray.set(i, i);
        }
        circularArray.rotate(2);
        for (int num : circularArray) {
            System.out.print(num + " ");
        }
    }
}    