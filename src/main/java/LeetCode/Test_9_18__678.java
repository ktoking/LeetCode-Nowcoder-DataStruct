package LeetCode;

import java.util.Stack;

/**
 * 678. 有效的括号字符串
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 *
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * 示例 1:
 *
 * 输入: "()"
 * 输出: True
 * 示例 2:
 *
 * 输入: "(*)"
 * 输出: True
 * 示例 3:
 *
 * 输入: "(*))"
 * 输出: True
 * 注意:
 *
 * 字符串大小将在 [1，100] 范围内。
 */
public class Test_9_18__678 {

    /**
     * 双栈判断
     * 1.贪心思想,首先当(或*进来的时候,入栈,然后当)进来的时候,直接先用(栈中去匹配,再用*去匹配,不符合就false
     * 2.当走完上面到下面的时候,就只剩(与*了,此时,判断(的下标是否大于*下标,大于就false
     * 3.最后如果还剩下(那肯定false
     * param s
     * @return
     */
    public boolean checkValidString(String s) {
        Stack<Integer> left=new Stack<>(),star=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(c=='('){
                left.push(i);
            }else if(c=='*'){
                star.push(i);
            }else {
                if(!left.isEmpty()){
                    left.pop();
                }else if(!star.isEmpty()){
                    star.pop();
                }else {
                    return false;
                }
            }
        }
        while (!left.isEmpty()&&!star.isEmpty()){
            if(left.pop()>star.pop()) return false;
        }
        return left.isEmpty();
    }
}
