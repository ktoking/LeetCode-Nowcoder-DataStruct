package LeetCode.swordToOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 *
 * 限制：
 *
 * 1 <= target <= 10^5
 */
public class Offer_10_29_57ii {

    /**
     * 滑动窗口解决问题
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> res=new ArrayList<>();
        int l=1,r=2,sum=l+r;
        while (l<r){
            if(sum<target){
                r++;
                sum+=r;
            }else if(sum>target){
                sum-=l;
                l++;
            }else {
                int[] arr=new int[r-l+1];
                for (int i = l; i <= r; i++) {
                    arr[i-l]=i;
                }
                res.add(arr);
                sum-=l;
                l++;
                r++;
                sum+=r;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
