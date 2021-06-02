package cn.iisheng.list;

import cn.iisheng.common.LinearNode;

/**
 * @author iisheng
 * @date 2020/05/30 22:26:02
 */
public class LinkedList implements ListADT {

    private LinearNode head;

    private LinearNode tail;

    /**
     * 头插法 创建链表
     *
     * @param node
     */
    @Override
    public void headInsert(LinearNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head = node;
        }
    }

    /**
     * 尾插法 创建链表
     *
     * @param node
     */
    @Override
    public void tailInsert(LinearNode node) {
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = tail.getNext();
        }
    }

    @Override
    public void print() {
        LinearNode temp = head;
        while (temp != null) {
            System.out.print(head.getElement() + " ");
            temp = temp.getNext();
        }
    }

}
