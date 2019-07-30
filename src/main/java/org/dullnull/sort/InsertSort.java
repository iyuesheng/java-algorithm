package org.dullnull.sort;

/**
 * @author iisheng
 * @date 2019/07/30 23:00:14
 */
public class InsertSort implements SortADT {

    /**
     * 将一个待排序元素 插入到已经排序的数组当中
     */
    @Override
    public <T extends Comparable> T[] sort(T[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int j;
            T temp = array[i];
            for (j = i; j > 0 && temp.compareTo(array[j - 1]) < 0; j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
        return array;
    }
}
