package cn.iisheng.stack;

import java.util.Arrays;

/**
 * @author iisheng
 * @date 2019/07/29 23:18:52
 */
public class ArrayStack<T> implements StackADT<T> {

    /**
     * 默认容量
     */
    private final int DEFAULT_CAPACITY = 100;

    /**
     * 栈顶元素下一个位置
     */
    private int top;

    /**
     * 存储栈元素的数组
     */
    private T[] stack;

    /**
     * 使用默认容量创建一个空栈
     */
    public ArrayStack() {
        top = 0;
        stack = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    /**
     * 使用指定容量创建一个空栈
     */
    public ArrayStack(int initialCapacity) {
        top = 0;
        stack = (T[]) (new Object[initialCapacity]);
    }

    /**
     * 添加一个元素
     * 确保 该数组不是满的
     * 把数组的top引用设置为要加入到栈中的对象
     * 增加top的值
     */
    @Override
    public void push(T element) {
        if (size() == stack.length) {
            expandCapacity();
        }
        stack[top] = element;
        top++;
    }

    private void expandCapacity() {
        stack = Arrays.copyOf(stack, stack.length * 2);
    }

    /**
     * 移除并返回栈顶元素
     * 确保 栈不为空
     * 减小top计数器
     * 设置一个临时引用等于stack[top]的元素
     * 设置stack[top]为空
     * 返回该临时引用
     */
    @Override
    public T pop() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("The stack is empty.");
        }
        top--;
        T result = stack[top];
        stack[top] = null;

        return result;
    }

    /**
     * 返回且不移除栈顶元素
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("The stack is empty.");
        }
        return stack[top - 1];
    }

    /**
     * 如果栈为空返回true
     */
    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    /**
     * 返回栈中元素数量
     */
    @Override
    public int size() {
        return top;
    }

    /**
     * 返回代表栈的字符串
     */
    @Override
    public String toString() {
        return Arrays.toString(stack);
    }
}
