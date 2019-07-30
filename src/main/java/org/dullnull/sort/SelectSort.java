package org.dullnull.sort;

/**
 * @author iisheng
 * @date 2019/07/30 22:26:59
 */
public class SelectSort implements SortADT {

    /**
     * 从待排序数组中选择一个最大或者最小的元素，与第一个元素交换
     */
    @Override
    public <T extends Comparable> T[] sort(T[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            T min = array[i];
            int minIdx = i;
            for (int j = i; j < length; j++) {
                if (array[j].compareTo(min) < 0) {
                    min = array[j];
                    minIdx = j;
                }
            }
            SortUtils.swap(array, i, minIdx);
        }
        return array;
    }
}
