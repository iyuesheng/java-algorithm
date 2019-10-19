package cn.iisheng.stack;

/**
 * @author iisheng
 * @date 2019/07/29 23:17:46
 */
public interface StackADT<T> {
    /**
     * 添加一个元素
     */
    void push(T element);

    /**
     * 移除并返回栈顶元素
     */
    T pop();

    /**
     * 返回且不移除栈顶元素
     */
    T peek();

    /**
     * 如果栈里面没有元素返回true
     */
    boolean isEmpty();

    /**
     * 返回栈中元素的总数
     */
    int size();

    /**
     * 返回一个代表当前栈的字符串
     */
    String toString();
}
