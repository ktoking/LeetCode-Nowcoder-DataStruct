package BUFFcode.WrittenTest.QiAnXian;

import java.util.List;

/**
 * 全排列问题
 *
 * 全排列的基本思想是：
 * 把待全排列记录分为两个部分：
 * （1） 第一个记录
 * （2） 剩下的所有元素
 * 所有记录的全排列就是所有可能出现在第一个位置的记录与剩下所有元素的全排列。
 * 以[1,2,3]为例，
 * 1,2,3的全排列可以看作是
 *    1,[2,3的全排列]
 *       [2,3]的全排列又可以看作是
 *          2,[3的全排列]—————对应123
 *          3,[2的全排列]—————对应132
 *    2,[1,3的全排列]
 *       [1,3]的全排列又可以看作是
 *          1,[3的全排列]—————对应213
 *          3,[1的全排列]—————对应231
 *    3,[1,2的全排列]
 *       [1,2]的全排列又可以看作是
 *          1,[2的全排列]—————对应312
 *          2,[1的全排列]—————对应321
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        fullSort(arr, 0, arr.length - 1);
    }

    public static void fullSort(int[] arr, int start, int end) {
        // 递归终止条件
        if (start == end) {
            for (int i : arr) {
                System.out.print(i);
            }
            System.out.println();
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(arr, i, start);
            fullSort(arr, start + 1, end);
            swap(arr, i, start);
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
