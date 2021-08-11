package LeetCode;

import java.util.Arrays;

/**
 * 354. 俄罗斯套娃信封问题
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 */
public class Test_8_10__354 {
    /**
     * 参考最长上升子序列做法，先把长排序，然后按照
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {
        /**
         比较naive的方法, 先按长排序, 然后按照O(N^2)的最长递增子序列的思想来做
         **/
        int n = envelopes.length;
        if(n < 1) return 0;
        int max = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); //每个信封最少为一个
        Arrays.sort(envelopes, (a,b) -> (a[0]-b[0]));
        for(int i = 1; i < n; ++i) {
            for(int j = 0; j < i; ++j) {
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
