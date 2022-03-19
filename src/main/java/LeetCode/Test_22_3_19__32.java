package LeetCode;

import io.swagger.models.auth.In;

import java.util.Stack;

/**
 * 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 *
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 *
 * 输入：s = ""
 * 输出：0
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 3 * 104
 * s[i] 为 '(' 或 ')'
 */
public class Test_22_3_19__32 {

    /**
     * 先标记出正确的 数组如 （（） 正确匹配上的括号的结果数组为 011  这时候我们找最长的1即可
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> stack=new Stack<>();
        int[] arr=new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==')'){
                if(stack.isEmpty()){
                    arr[i]=0;
                }else {
                    arr[i]=1;
                    arr[stack.pop()]=1;
                }
            }else {
                stack.push(i);
            }
        }
        int len=0,max=0;
        for (int a : arr) {
            if(a==0){
                len=0;
            }else {
                len++;
            }
            max=Math.max(len,max);
        }
        return max;
    }
}
