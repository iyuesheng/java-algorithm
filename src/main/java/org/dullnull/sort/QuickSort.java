package org.dullnull.sort;

/**
 * @author iisheng
 * @date 2019/08/04 23:39:45
 */
public class QuickSort implements SortADT {

    @Override
    public <T extends Comparable> T[] sort(T[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    /**
     * 选择一个列表元素作为分区元素，然后分别对两个分区进行递归排序
     */
    private <T extends Comparable> void quickSort(T[] array, int min, int max) {

        if (min < max) {
            int partition = partition(array, min, max);

            quickSort(array, min, partition - 1);

            quickSort(array, partition + 1, max);
        }
    }

    /**
     * 选择分区元素
     */
    private <T extends Comparable> int partition(T[] array, int min, int max) {
        T middleElement;
        int left, right;
        int middle = (min + max) / 2;

        // 使用中间元素作为分区元素
        middleElement = array[middle];

        // 将分区元素放在数组第一位
        SortUtils.swap(array, middle, min);

        left = min;
        right = max;

        while (left < right) {

            // 查找大于分区元素的元素
            while (left < right && array[left].compareTo(middleElement) <= 0) {
                left++;
            }

            // 查找小于等于分区元素的元素
            while (array[right].compareTo(middleElement) > 0) {
                right--;
            }

            // 将大于分区元素的元素，放在分区元素右面
            // 将小于等于分区元素的元素，放在分区元素左面
            if (left < right) {
                SortUtils.swap(array, left, right);
            }
        }

        // 将分区元素放在分区元素的位置
        SortUtils.swap(array, min, right);

        return right;
    }
}
