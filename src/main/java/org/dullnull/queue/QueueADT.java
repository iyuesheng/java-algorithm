package org.dullnull.queue;

/**
 * @author iisheng
 * @date 2019/07/30 23:11:21
 */
public interface QueueADT<T> {

    /**
     * 向队列末端添加一个元素
     *
     * @param element
     */
    void enqueue(T element);

    /**
     * 从队列前端删除一个元素
     *
     * @param element
     */
    T dequeue(T element);

    /**
     * 返回队列最前端的元素，但不移出
     *
     * @return
     */
    T first();

    /**
     * 如果队列为空返回true
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 返回队列中元素的数量
     *
     * @return
     */
    int size();

    /**
     * 返回队列字符串表示
     *
     * @return
     */
    String toString();
}
