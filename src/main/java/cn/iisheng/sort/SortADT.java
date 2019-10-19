package cn.iisheng.sort;

/**
 * @author iisheng
 * @date 2019/07/30 01:10:53
 */
public interface SortADT {

    /**
     * 排序方法抽象
     *
     * @param unsorted 未排序数组
     * @param <T>      Comparable子类
     * @return 排好序后的数组
     */
    <T extends Comparable> T[] sort(T[] unsorted);
}
