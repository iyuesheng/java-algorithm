package org.dullnull.sort;

import java.util.Arrays;
import java.util.List;

/**
 * @author iisheng
 * @date 2019/07/30 08:33:05
 */
public final class SortUtils {

    /**
     * 交换数组中两个元素的位置
     *
     * @param array 数组
     * @param idx   下标x
     * @param idy   下标y
     * @param <T>   泛型
     */
    public static <T> void swap(T[] array, int idx, int idy) {
        T temp = array[idx];
        array[idx] = array[idy];
        array[idy] = temp;
    }

    public static void print(List<?> toPrint) {
        toPrint.stream()
                .map(Object::toString)
                .map(str -> str + "")
                .forEach(System.out::print);

        System.out.println();
    }

    public static void print(Object[] toPrint) {
        System.out.println(Arrays.toString(toPrint));
    }

}
