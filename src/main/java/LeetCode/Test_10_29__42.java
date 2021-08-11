package LeetCode;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 *
 * 提示：
 *
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 */
public class Test_10_29__42 {
    /**
     * https://leetcode-cn.com/problems/trapping-rain-water/solution/42-jie-yu-shui-shuang-zhi-zhen-dong-tai-gui-hua-da/
     * 动态规划解决,首先找出规律,按照每一列来进行计算,每列存的雨水值为 min(左边墙的高度,右边墙的高度)-当前列的高度
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if(height.length<=2) return 0;
        int count=0;
        int[] maxl=new int[height.length];
        int[] maxr=new int[height.length];
        maxl[0]=height[0];
        for (int i = 1; i < height.length; i++) {
            maxl[i]=Math.max(maxl[i-1],height[i]);
        }
        maxr[height.length-1]=height[height.length-1];
        for (int i = height.length-2; i >= 0; i--) {
            maxr[i]=Math.max(maxr[i+1],height[i]);
        }
        for (int i = 0; i < height.length; i++) {
            int numX=Math.min(maxl[i],maxr[i])-height[i];
            if(numX>0) count+=numX;
        }
        return count;
    }
}
