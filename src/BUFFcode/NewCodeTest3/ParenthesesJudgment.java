package BUFFcode.NewCodeTest3;

import java.util.Scanner;
import java.util.Stack;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/d8acfa0619814b2d98f12c071aef20d4
 * 来源：牛客网
 *
 * 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
 *
 * 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
 *
 * 测试样例：
 * "(()())",6
 * 返回：true
 * 测试样例：
 * "()a()()",7
 * 返回：false
 * 测试样例：
 * "()(()()",7
 * 返回：false
 *
 * 解体思路,使用栈,当输入 ( 我们压入栈中, 要是下一个输入的是 ) 我们弹出栈顶元素 最后判断栈是否为空,注意判断条件
 */
public class ParenthesesJudgment {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.nextLine();
            System.out.println(chkParenthesis(s,s.length()));
        }
    }

    public static   boolean chkParenthesis(String A, int n) {
        Stack<Character> stack=new Stack();
        if(A==null&&A.length()!=n) return  false;
        for (int i = 0; i < A.length(); i++) {
            if(A.charAt(i)=='('){
                stack.push('(');
            }else if(A.charAt(i)==')'){
                if(stack.empty()) return false;
                else { stack.pop(); }
            }else {
                return false;
            }
        }
        if(stack.empty()){
            return true;
        }else {
            return false;
        }
    }
}
