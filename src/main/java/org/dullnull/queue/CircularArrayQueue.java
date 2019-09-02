package org.dullnull.queue;

/**
 * @author iisheng
 * @date 2019/09/02 21:39:31
 */
public class CircularArrayQueue<T> implements QueueADT<T> {

    private static final int DEFAULT_CAPACITY = 100;
    private int front, rear, count;
    private T[] queue;

    public CircularArrayQueue(int capacity) {
        front = rear = count = 0;
        queue = (T[]) new Object[capacity];
    }

    public CircularArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void enqueue(T element) {
        if (size() == queue.length) {
            expandCapacity();
        }

        queue[rear] = element;
        rear = (rear + 1) % queue.length;

        count++;
    }

    @Override
    public T dequeue(T element) {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        }

        T result = queue[front];
        front = (front + 1) % queue.length;

        count--;
        return result;
    }

    @Override
    public T first() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        }
        return queue[front];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    public void expandCapacity() {
        T[] larger = (T[]) new Object[queue.length * 2];
        for (int i = 0; i < count; i++) {
            larger[i] = queue[front];
            front = (front + 1) % queue.length;
        }
        front = 0;
        rear = count;
        queue = larger;
    }
}
