package com.coderscampus.assignment5;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {
    private final int CAPACITY_INCREASE_MULTIPLIER = 2;
    private int capacity;
    private int nextIndex;
    private Object[] items;

    public CustomArrayList(int initialCapacity) {
        this.setCapacity(initialCapacity);
        this.nextIndex = 0;
        items = new Object[initialCapacity];
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) throws IllegalArgumentException {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be a positive integer. Value passed: " + capacity);
        }
        this.capacity = capacity;
    }

    @Override
    public boolean add(T item) {
        if (item == null) { return false; }
        if (this.getSize() >= this.getCapacity()) {
            this.capacity *= CAPACITY_INCREASE_MULTIPLIER;
            Object[] newItems = new Object[this.capacity];
            System.arraycopy(this.items, 0, newItems, 0, this.getSize());
            this.items = newItems;
        }
        this.items[this.nextIndex] = item;
        this.nextIndex++;
        return true;
    }

    @Override
    public int getSize() {
        return this.nextIndex;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.nextIndex) {
            throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds.");
        }
        return (T) this.items[index];
    }
}
