package LeetCode;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Test_8_21__5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }
    /**
     * 暴力解法
     * 首先暴力遍历所有可能的字符串，记录最长字符串长度，每次只判断长度大于的最大长度的进下一步，最后再依次校验是否为字符串即可
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if(s.length()<2) return s;
        int begin=0;
        int maxLen=1;
        for (int i = 0; i < s.length()-1; i++) {
            for (int j = i+1; j < s.length(); j++) {
                if(j-i+1>maxLen&&vaild(s,i,j)){
                    maxLen=j-i+1;
                    begin=i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
    public static boolean vaild(String s,int i,int j){
        while (i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else {
                break;
            }
        }
        return i>j?true:false;
    }



}
