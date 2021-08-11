package BUFFcode.WrittenTest.TuHuYangChe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param array1 int整型一维数组
     * @param n int整型
     * @param array2 int整型一维数组
     * @param m int整型
     * @return int整型一维数组
     */
    public static int[] arrayMerge (int[] array1, int n, int[] array2, int m) {
        // write code here
        int arr[]=new int[m+n];
        int l=0,r=m-1,i=0;
        while (l<n&&r>=0){
            if(array1[l]<array2[r]){
                arr[i]=array1[l];
                l++;
            }else {
                arr[i]=array2[r];
                r--;
            }
            i++;
        }
        if(i==m+n){
            return arr;
        }else if(l>=n){
            for (int j = r; j >=0; j--) {
                arr[i]=array2[j];
                i++;
            }
        }else if(r<0){
            for (int j = l; j < n; j++) {
                arr[i]=array1[j];
                i++;
            }
        }
        return arr;
    }


}
