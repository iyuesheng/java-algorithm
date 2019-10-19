package cn.iisheng.stack;

import cn.iisheng.common.LinearNode;

/**
 * @author iisheng
 * @date 2019/07/29 23:32:13
 */
public class LinkedStack<T> implements StackADT<T> {

    /**
     * 在栈中存储元素的数量
     */
    private int count;

    /**
     * 指向栈顶的指针
     */
    private LinearNode<T> top;

    public LinkedStack() {
        count = 0;
        top = null;
    }


    @Override
    public void push(T element) {
        LinearNode<T> temp = new LinearNode<>(element);

        temp.setNext(top);
        top = temp;
        count++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty.");
        }

        T result = top.getElement();
        top = top.getNext();
        count--;

        return result;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("The stack is empty.");
        }
        return top.getElement();
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }
}
