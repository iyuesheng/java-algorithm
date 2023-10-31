package cn.iisheng.cache;

import java.util.HashMap;

/**
 * @author iisheng
 * @date 2022/08/31 10:08:41
 * @description 最基本的LruCache
 */
public class LruCache {
    
    private Node head;
    private Node tail;
    private int capacity;
    
    HashMap<String, Node> map;
    
    public LruCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }
    
    public String get(String key) {
        Node node = map.get(key);
        if (node == null) {
            throw new RuntimeException("key not exit");
        }
        moveNodeTail(node);
        return node.value;
    }
    
    public void put(String key, String value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            moveNodeTail(node);
        } else {
            // key not exit
            if (map.size() >= capacity) {
                String oldKey = deleteNode(head);
                map.remove(oldKey);
            }
            
            node = new Node(key, value);
            addTailNode(node);
            map.put(key, node);
        }
    }
    
    private void moveNodeTail(Node node) {
        if (node == tail) {
            return;
        }
        
        deleteNode(node);
        
        addTailNode(node);
    }
    
    private String deleteNode(Node node) {
        if (node == head && node == tail) {
            head = null;
            tail = null;
        } else if (node == tail) {
            tail = tail.pre;
            tail.next = null;
        } else if (node == head) {
            head = head.next;
            head.pre = null;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        return node.key;
    }
    
    private void addTailNode(Node node) {
        if (tail != null) {
            tail.next = node;
            node.pre = tail;
            node.next = null;
        }
        tail = node;
        if (head == null) {
            head = node;
        }
    }
    
}