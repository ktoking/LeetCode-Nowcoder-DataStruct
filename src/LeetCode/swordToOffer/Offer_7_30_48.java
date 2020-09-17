package LeetCode.swordToOffer;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 * 提示：
 *
 * s.length <= 40000
 */
public class Offer_7_30_48 {

    /**
     * 滑动窗口,每次向右移动同力扣第3题
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)return 0;
        int count=0,right=0;
        Set<Character> set=new HashSet();
        for (int i = 0; i < s.length(); i++) {
            if(i!=0){
                set.remove(s.charAt(i-1));
            }
            while (right<s.length()&&!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }
            count=Math.max(count,right-i);
        }
        return count;
    }

    /**
     * 最长不含重复字符的子字符串,再写一遍
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        if(s.length()==0||s==null) return 0;
        int count=0,right=0;
        Set<Character> set=new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if(i!=0){
                set.remove(s.charAt(i-1));
            }
            while (right<s.length()&&!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }
            count=Math.max(count,right-i);
        }
        return count;
    }
}
