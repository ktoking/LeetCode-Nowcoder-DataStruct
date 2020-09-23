package LeetCode;

/**
 * 926. 将字符串翻转到单调递增
 * 如果一个由 '0' 和 '1' 组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，那么该字符串是单调递增的。
 *
 * 我们给出一个由字符 '0' 和 '1' 组成的字符串 S，我们可以将任何 '0' 翻转为 '1' 或者将 '1' 翻转为 '0'。
 *
 * 返回使 S 单调递增的最小翻转次数。
 *
 *
 *
 * 示例 1：
 *
 * 输入："00110"
 * 输出：1
 * 解释：我们翻转最后一位得到 00111.
 * 示例 2：
 *
 * 输入："010110"
 * 输出：2
 * 解释：我们翻转得到 011111，或者是 000111。
 * 示例 3：
 *
 * 输入："00011000"
 * 输出：2
 * 解释：我们翻转得到 00000000。
 */
public class Test_9_23__926 {

    /**
     * 对于每个元素，分别统计该元素左边0的个数leftZero和该元素右边1的个数rightOne。
     * 如果以位置i为分隔点，则左边需要将i-leftZero[i]个1转换为0，右边需要将len-i-1-rightOne[i]个0转换为1，共计需要转换
     * len-1-leftZero[i]-rightOne[i]次。
     *
     * 作者：william134
     * 链接：https://leetcode-cn.com/problems/flip-string-to-monotone-increasing/solution/javadong-tai-gui-hua-yong-shi-ji-bai-8927-by-willi/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int minFlipsMonoIncr(String S) {
        char[] chars = S.toCharArray();
        int len = chars.length;

        int[] leftZero = new int[len];
        for (int i=1;i<len;i++)
            leftZero[i]=leftZero[i-1]+(chars[i-1]=='0'?1:0);

        int[] rightOne = new int[len];
        for (int i=len-2;i>=0;i--)
            rightOne[i]=rightOne[i+1]+(chars[i+1]=='1'?1:0);

        int min = Integer.MAX_VALUE;
        for (int i=0;i<len;i++){
            min=Math.min(min,len-1-leftZero[i]-rightOne[i]);
        }
        return min;
    }
}
