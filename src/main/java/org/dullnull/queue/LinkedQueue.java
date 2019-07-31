package org.dullnull.queue;

import org.dullnull.common.LinearNode;

/**
 * @author iisheng
 * @date 2019/07/31 08:07:21
 */
public class LinkedQueue<T> implements QueueADT<T> {


    private int count;

    private LinearNode<T> head, tail;


    public LinkedQueue() {
        count = 0;
        head = tail = null;
    }

    @Override
    public void enqueue(T element) {
        LinearNode<T> node = new LinearNode(element);
        if (isEmpty()) {
            head = node;
        } else {
            tail.setNext(node);
        }
        tail = node;
        count++;
    }

    @Override
    public T dequeue(T element) {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        }
        T result = head.getElement();
        head = head.getNext();
        count--;

        if (isEmpty()) {
            tail = null;
        }

        return result;
    }

    @Override
    public T first() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        }
        return head.getElement();
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        return "";
    }
}
