package BUFFcode.WrittenTest.BiLiBiLi;

import java.util.Stack;

public class Main1 {

    public boolean IsValidExp (String s) {
        // write code here
        Stack<Character> stack=new Stack<>();
        if(s==null||s=="") return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c==')'||c==']'||c=='}'){
                if(stack.isEmpty()) return false;
                if(stack.peek()=='('&&c==')'){
                        stack.pop();
                }else if(stack.peek()=='['&&c==']') stack.pop();
                else if(stack.peek()=='{'&&c=='}') stack.pop();
                else {
                    return false;
                }
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
