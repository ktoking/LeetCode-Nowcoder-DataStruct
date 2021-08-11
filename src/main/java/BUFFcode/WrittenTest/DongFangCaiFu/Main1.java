package BUFFcode.WrittenTest.DongFangCaiFu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.cnblogs.com/neuzk/p/9501864.html 打家劫舍
 */
public class Main1 {
    /**
     * 今天下午面试老虎证券，被问到这题，当时脑子有点蒙，代码没写出来。这题的意思就是给你一个数组，让你计算元素的和，但是这些元素都不能相邻，求最大的和。其实这题很常见，在leetcode上面也有，但是原题是这样的：
     *
     * 假设你是一个专业的窃贼，准备沿着一条街打劫房屋。每个房子都存放着特定金额的钱。你面临的唯一约束条件是：相邻的房子装着相互联系的防盗系统，且 当相邻的两个房子同一天被打劫时，该系统会自动报警。给定一个非负整数列表，表示每个房子中存放的钱， 算一算，如果今晚去打劫，你最多可以得到多少钱 在不触动报警装置的情况下。
     *
     * 例如：
     * 数组arr为[1, 3, 5, 4, 9]，那么结果为 1 + 5 + 9 = 15，再例如数组arr为[5, 1, 3, 11, 7]，那么结果为5 + 11 = 16，从这两个例子可以看出，单纯的计算奇数位的和或者偶数位的和得到的结果未必是最大的。
     * 解题思路：
     * 定义一个数组p，p[i] 代表从第0到第i个房屋，打劫第i个房屋为止所获得金钱总额，也就是说第i个房屋要打劫，而p[i]肯定等于arr[i] + p[i-2]或者arr[i] + p[i-3]的最大值，因为相邻的房屋不能打劫，所以p[i-1]不能算。最后我们只要计算p[arr.length-1]和p[arr.length-2]哪个大就行了。p[arr.length-3]肯定不是最大的，因为p[arr.length-3] + arr[arr.length-1]肯定比p[arr.length-3]大。
     * @param arr
     * @return
     */
    public static int getMaxSum(int[] arr) {
        if(arr.length == 0) return 0;
        if(arr.length == 1) return arr[0];
        if(arr.length == 2) return Math.max(arr[0], arr[1]);
        if(arr.length == 3) return Math.max(arr[1], arr[0] + arr[2]);
        int[] p = new int[arr.length];
        p[0] = arr[0];
        p[1] = arr[1];
        p[2] = arr[0] + arr[2];
        for(int i = 3; i < arr.length; i++) {
            p[i] = arr[i] + Math.max(p[i-2], p[i-3]);
        }
        return Math.max(p[arr.length-1],p[arr.length-2]);
    }
}
