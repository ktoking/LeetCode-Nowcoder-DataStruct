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

    /**
     * 中心扩散算法
     * @param s
     * @return
     */
    public static String longestPalindrome1(String s) {
        if(s.length()==0||s==null) return "";
        int left=0,maxS=0,right=0,maxLen=0,len=1;
        for (int i = 0; i < s.length(); i++) {
            left=i-1;
            right=i+1;
            while (left>=0&&s.charAt(i)==s.charAt(left)){
                left--;
                len++;
            }
            while (right<s.length()&&s.charAt(right)==s.charAt(i)){
                right++;
                len++;
            }
            while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                len+=2;
                left--;
                right++;
            }
            if(len>maxLen){
                maxLen=len;
                maxS=left;
            }
            len = 1;
        }
        return s.substring(maxS+1,maxS+maxLen+1);
    }

    /**
     * 中心扩散法
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {

        if(s.length()==0||s==null) return "";
        int maxL=0,maxLen=0;
        for (int i = 0; i < s.length(); i++) {
            int left=i-1;
            int right=i+1;
            int len=1;
            while (left>=0&&s.charAt(left)==s.charAt(i)){
                left--;
                len++;
            }
            while (right<s.length()&&s.charAt(right)==s.charAt(i)){
                right++;
                len++;
            }
            while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                left--;
                right++;
                len+=2;
            }
            if(len>maxLen){
                maxLen=len;
                maxL=left;
            }
        }
        return s.substring(maxL+1,maxL+maxLen+1);
    }

}
