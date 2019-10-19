package cn.iisheng.sort;

/**
 * @author iisheng
 * @date 2019/07/30 21:44:37
 */
public class BubbleSort implements SortADT {

    /**
     * 从头到尾遍历数组，第一次遍历将最小或者最大值 下沉到 最后一个位置
     */
    @Override
    public <T extends Comparable> T[] sort(T[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    SortUtils.swap(array, j, j + 1);
                }
            }
        }
        return array;
    }
}
