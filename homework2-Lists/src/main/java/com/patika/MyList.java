package com.patika;

import java.util.Arrays;

public class MyList<T> {
    private T[] array;
    private int size;

    @SuppressWarnings("unchecked")
    public MyList() {
        array = (T[]) new Object[10]; // Varsayılan kapasite 10
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public MyList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }
        array = (T[]) new Object[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public int getCapacity() {
        return array.length;
    }

    @SuppressWarnings("unchecked")
    public void add(T data) {
        if (size == array.length) {
            // Dizi boyutunu iki katına çıkar
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size++] = data;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return array[index];
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        T removedElement = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = null;
        return removedElement;
    }

    public T set(int index, T data) {
        if (index < 0 || index >= size) {
            return null;
        }
        T oldValue = array[index];
        array[index] = data;
        return oldValue;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, size));
    }

    public int indexOf(T data) {
        for (int i = 0; i < size; i++) {
            if (data.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        for (int i = size - 1; i >= 0; i--) {
            if (data.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
        return (T[]) Arrays.copyOf(array, size);
    }

    public void clear() {
        Arrays.fill(array, 0, size, null);
        size = 0;
    }

    public MyList<T> subList(int start, int finish) {
        if (start < 0 || finish > size || start > finish) {
            throw new IndexOutOfBoundsException("Invalid index range");
        }
        MyList<T> subList = new MyList<>(finish - start);
        for (int i = start; i < finish; i++) {
            subList.add(array[i]);
        }
        return subList;
    }

    public boolean contains(T data) {
        return indexOf(data) != -1;
    }
}
