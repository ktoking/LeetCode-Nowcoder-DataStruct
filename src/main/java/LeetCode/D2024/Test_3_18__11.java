package LeetCode.D2024;

import java.util.HashMap;
import java.util.Map;


/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 * <p>
 * 说明：你不能倾斜容器。
 */
public class Test_3_18__11 {

    /**
     * 双指针解法,max面积等于长(r-l)乘宽(min最短那一块)
     * 可以看出来面积取决于最短那一条木板长度,所以每次移动最短木板后比较大小即可
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, max = 0;
        while (l < r) {
            max = Math.max(max, (r - l) * Math.min(height[l] , height[r]));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }

}

