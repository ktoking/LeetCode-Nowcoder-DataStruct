package LeetCode;

import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 */
public class Test_9_18__20 {

    /**
     * 括号匹配,注意] [ 时栈中状态
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if(s.length()==0||s==null) return false;
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==')'){
                if(stack.isEmpty()||stack.pop()!='(') return false;
            }else if(s.charAt(i)==']'){
                if(stack.isEmpty()||stack.pop()!='[') return false;
            }else if(s.charAt(i)=='}'){
                if(stack.isEmpty()||stack.pop()!='{') return false;
            }else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }


    /**
     * 括号匹配
     * @param s
     * @return
     */
    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character kuohao : s.toCharArray()) {
            if(kuohao==')'){ if(stack.isEmpty()||stack.pop()!='(') return false; }
            else if(kuohao=='}'){ if(stack.isEmpty()||stack.pop()!='{') return false; }
            else if(kuohao==']'){ if(stack.isEmpty()||stack.pop()!='[') return false; }
            else stack.push(kuohao);
        }
        return stack.isEmpty();
    }


}
