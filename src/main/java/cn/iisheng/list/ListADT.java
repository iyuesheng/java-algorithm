package cn.iisheng.list;

import cn.iisheng.common.LinearNode;

/**
 * @author iisheng
 * @date 2020/05/30 22:25:38
 */
public interface ListADT {
    /**
     * 头部插入
     *
     * @param node
     */
    void headInsert(LinearNode node);

    /**
     * 尾部插入
     *
     * @param node
     */
    void tailInsert(LinearNode node);

    /**
     * 打印
     */
    void print();
}
