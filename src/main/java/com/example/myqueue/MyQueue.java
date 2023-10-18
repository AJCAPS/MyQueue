package com.example.myqueue;
public class MyQueue<T> implements QueueInterface<T> {
    private static final int MAX_SIZE = 100; // Assuming a maximum size for the queue
    private T[] queue;
    private int front = 0; // Pointing to the first element in the queue.
    private int rear = -1; // No elements in the beginning, so rear is -1.
    private int size = 0; // Number of elements in the queue.
    @SuppressWarnings("unchecked")
    public MyQueue() {
        queue = (T[]) new Object[MAX_SIZE]; // Initializing the generic array
    }
    @Override
    public void push(T item) {
        if (size >= MAX_SIZE) {
            throw new IllegalStateException("Queue is full.");
        }
        rear = (rear + 1) % MAX_SIZE; // Circular queue
        queue[rear] = item;
        size++;
    }
    @Override
    public T pop() {
        if (empty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        T item = queue[front];
        front = (front + 1) % MAX_SIZE; // Circular queue
        size--;
        return item;
    }
    @Override
    public T front() {
        if (empty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        return queue[front];
    }
    @Override
    public T back() {
        if (empty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        return queue[rear];
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean empty() {
        return size == 0;
    }
}

