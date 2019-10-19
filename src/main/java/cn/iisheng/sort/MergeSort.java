package cn.iisheng.sort;

/**
 * @author iisheng
 * @date 2019/08/05 19:59:34
 */
public class MergeSort implements SortADT {

    @Override
    public <T extends Comparable> T[] sort(T[] array) {
        mergeSort(array, 0, array.length - 1);
        return array;
    }

    private <T extends Comparable> void mergeSort(T[] array, int min, int max) {
        if (min < max) {
            int mid = (min + max) / 2;
            mergeSort(array, min, mid);
            mergeSort(array, mid + 1, max);
            merge(array, min, mid, max);
        }
    }

    /**
     * 将两个排好序的子序列合并
     */
    private <T extends Comparable> void merge(T[] array, int first, int mid, int last) {
        T[] temp = (T[]) new Comparable[last - first + 1];

        int i = first;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= last) {
            if (array[i].compareTo(array[j]) < 0) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = array[i++];
        }

        while (j <= last) {
            temp[k++] = array[j++];
        }

        for (int p = 0; p < temp.length; p++) {
            array[first + p] = temp[p];
        }
    }
}
