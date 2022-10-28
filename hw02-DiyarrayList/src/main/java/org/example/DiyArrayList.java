package org.example;

import java.util.*;

public class DiyArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size = 0;

    public DiyArrayList() {
        elements = new Object[0];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Object element : elements) {
            if (o == element) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new DIYArrayIterator<>(elements, size);
    }

    @Override
    public Object[] toArray() {
        Object[] tmp = new Object[size];

        int index = 0;

        for (Object o : this.elements) {
            if (o != null) {
                tmp[index] = o;
                index++;
            }
        }
        return tmp;
    }

    @Override
    public <T> T[] toArray(T[] toArray) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(E element) {
        if (size == 0) {
            elements = new Object[DEFAULT_CAPACITY];
        } else if (isFull()) {
            copyArray(true);
        }
        elements[size++] = element;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> elements) {
        for (E element : elements) {
            add(element);
        }
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        checkRange(index);
        return (E) elements[index];
    }

    @Override
    public E set(int index, E element) {
        checkRange(index);
        elements[index] = element;
        return element;
    }

    @Override
    public String toString() {
        return "DiyArrayList{" +
                "arrayList=" + toStr(toArray()) +
                ", size=" + size +
                '}';
    }

    @Override
    public ListIterator<E> listIterator() {
        return new DIYArrayIterator<>(elements, size);
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    private void checkRange(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Index: %d, Size: %d", index, size));
        }
    }

    private void copyArray(boolean toIncrease) {
        int newSize = size;

        if (toIncrease) {
            newSize = this.elements.length * 2;
        }

        Object[] tmp = new Object[newSize];

        int index = 0;

        for (Object o : this.elements) {
            if (o != null) {
                tmp[index] = o;
                index++;
            }
        }
        this.elements = tmp;
    }

    private boolean isFull() {
        return this.elements.length == this.size;
    }

    private String toStr(Object[] arr) {
        StringBuilder a = new StringBuilder();
        a.append('[');
        boolean i = true;
        for (Object o : arr) {
            if (i) {
                a.append(o);
                i = false;
            } else {
                a.append(", ");
                a.append(o);
            }
        }
        a.append(']');
        return a.toString();
    }

    private static final class DIYArrayIterator<E> implements ListIterator<E> {

        private final Object[] elements;
        private final int size;
        private int index;

        public DIYArrayIterator(Object[] elements, int size) {
            this.elements = elements;
            this.size = size;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public E next() {
            if (hasNext()) {
                return (E) elements[index++];
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override
        public boolean hasPrevious() {
            return index > 0;
        }

        @Override
        @SuppressWarnings("unchecked")
        public E previous() {
            if (hasPrevious()) {
                return (E) elements[index - 1];
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override
        public int nextIndex() {
            return index + 1;
        }

        @Override
        public int previousIndex() {
            return index - 1;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(E e) {
            elements[index - 1] = e;
        }

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException();
        }
    }
}
