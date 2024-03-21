package LeetCode.D2024;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 示例 1：
 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 输出：6
 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 示例 2：
 输入：height = [4,2,0,3,2,5]
 输出：9
 */
public class Test_3_20__42 {


    /**
     * 按列分,每列存储的水为min(左边最高列-右边最高列)-当前列长度
     * 两个数组每个数组统计当前左边最大列与右边最大列,然后套公式就行
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int[] maxLArray=new int[height.length];
        int[] maxRArray=new int[height.length];
        int maxL=0,maxR=0;
        for (int i = 0; i < height.length - 1; i++) {
            maxL=Math.max(maxL,height[i]);
            maxLArray[i]=maxL;
        }
        for (int i = height.length-1; i >0; i--) {
            maxR=Math.max(maxR,height[i]);
            maxRArray[i]=maxR;
        }
        int maxCount=0;
        for (int i = 0; i < height.length; i++) {
            int count=Math.min(maxLArray[i],maxRArray[i])-height[i];
            if(count>0) maxCount+=count;
        }
        return maxCount;
    }

}

