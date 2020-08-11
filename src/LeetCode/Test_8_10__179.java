package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 179. 最大数
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: 210
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class Test_8_10__179 {

    /**'
     * 重写compareTo方法，变成string然后再比较
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        String[] strs=new String[nums.length];
        for (int i = 0; i < strs.length; i++) {
            strs[i]=String.valueOf(nums[i]);
        }

        Arrays.sort(strs,(o1,o2)->{
            return (o2+o1).compareTo(o1+o2);
        });
        StringBuilder sb = new StringBuilder();
        for (String aStrArr : strs) {
            sb.append(aStrArr);
        }
        String result = sb.toString();
        //特殊情况 若干个零
        if (result.charAt(0) == '0') {
            result = "0";
        }
        return result;
    }

}
