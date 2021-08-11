package LeetCode;

/**
 * 459. 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * 示例 1:
 *
 * 输入: "abab"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 *
 * 输入: "aba"
 *
 * 输出: False
 * 示例 3:
 *
 * 输入: "abcabcabcabc"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */
public class Test_9_22__459 {
    /**
     * 判断是否为循环字符串
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        return (s+s).substring(1,s.length()*2-1).contains(s);
    }


    public static void main(String[] args) {
        kmp("ababab");
    }
    /**
     * 字符串的最小循环节,kmp算法,输出长度
     * @param pattern
     */
    public static void kmp(String pattern){
        int next[] = new int[pattern.length()+1];
        next[0] = -1;
        int i = 0, j = -1, m = pattern.length();
        while(i < m) {//求前缀数组
            if (j == -1 || pattern.charAt(j) == pattern.charAt(i))	next[++i] = ++j;
            else	j = next[j];
        }
        int temp = m - next[m];//next[m]就是多求的一位
        if(m%temp != 0)System.out.print(m);
        else System.out.print(temp);
    }
}
