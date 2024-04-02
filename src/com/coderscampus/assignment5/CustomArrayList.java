package com.coderscampus.assignment5;


import java.util.Arrays;
import java.util.stream.Stream;

@SuppressWarnings("unchecked")
public class CustomArrayList<T> implements CustomList<T> {
    private static final int CAPACITY_INCREASE_MULTIPLIER = 2;
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private int capacity;
    private int size;
    private T[] items;

    public CustomArrayList() {
        this.capacity = DEFAULT_INITIAL_CAPACITY;
        this.size = 0;
        this.items = (T[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public CustomArrayList(int initialCapacity) throws IllegalArgumentException {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Capacity must be a positive integer. Value passed: " + initialCapacity);
        }
        this.capacity = initialCapacity;
        this.size = 0;
        this.items = (T[]) new Object[initialCapacity];
    }

    @Override
    public boolean add(T item) {
        if (this.getSize() >= this.capacity) {
            this.capacity *= CAPACITY_INCREASE_MULTIPLIER;
//            T[] newItems = (T[]) new Object[this.capacity];
//            System.arraycopy(this.items, 0, newItems, 0, this.getSize());
//            this.items = newItems;
            this.items = Arrays.copyOf(this.items, this.capacity);
        }
        this.items[this.size] = item;
        this.size++;
        return true;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds.");
        }
        return this.items[index];
    }

    // experimenting - made it streamable for learning purposes
    @Override
    public Stream<T> stream() {
        return Arrays.stream(this.items, 0, this.size);
    }
}
