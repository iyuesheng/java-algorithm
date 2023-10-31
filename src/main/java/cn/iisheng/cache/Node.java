package cn.iisheng.cache;

/**
 * @author iisheng
 * @date 2022/09/01 01:14:50
 */
public class Node {
    public Node pre;
    public Node next;
    public String key;
    public String value;
    
    public Node(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
