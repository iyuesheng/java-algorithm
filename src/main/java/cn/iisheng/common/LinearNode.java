package cn.iisheng.common;

/**
 * @author iisheng
 * @date 2019/07/29 23:35:34
 */
public class LinearNode<T> {

    /**
     * 当前节点的下一个节点
     */
    private LinearNode<T> next;

    /**
     * 当前节点存储的元素
     */
    private T element;

    /**
     * 创建一个空节点
     */
    public LinearNode() {
        next = null;
        element = null;
    }

    /**
     * 创建一个带特殊元素的节点
     *
     * @param element
     */
    public LinearNode(T element) {
        next = null;
        this.element = element;
    }

    /**
     * 返回当前节点的下一个节点
     *
     * @return
     */
    public LinearNode<T> getNext() {
        return next;
    }

    /**
     * 设置当前节点的下一个节点
     *
     * @param node
     */
    public void setNext(LinearNode<T> node) {
        next = node;
    }

    /**
     * 返回节点中存储的数据
     *
     * @return
     */
    public T getElement() {
        return element;
    }

    /**
     * 设置节点中存储的数据
     *
     * @param element
     */
    public void setElement(T element) {
        this.element = element;
    }
}