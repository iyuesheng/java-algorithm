package cn.iisheng.sort;

import org.junit.Test;

/**
 * @author iisheng
 * @date 2019/07/30 21:52:16
 */
public class SortTest {

    private Integer[] array = {10, 3, 5, 2, 6, 7, 9, 1};

    @Test
    public void bubbleSortTest() {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(array);

        SortUtils.print(array);
    }

    @Test
    public void selectSortTest() {
        SelectSort selectSort = new SelectSort();
        selectSort.sort(array);

        SortUtils.print(array);
    }

    @Test
    public void insertSortTest() {
        InsertSort insertSort = new InsertSort();
        insertSort.sort(array);

        SortUtils.print(array);
    }

    @Test
    public void quickSortTest() {
        QuickSort quickSort = new QuickSort();
        quickSort.sort(array);

        SortUtils.print(array);
    }

    @Test
    public void mergeSortTest() {
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(array);

        SortUtils.print(array);
    }
}
