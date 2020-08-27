package BUFFcode.WrittenTest.PuTaoCheng;

import java.util.Scanner;
import java.util.Stack;

/**
 * (   (
 * dary罗红波
 *   (  ）]
 * dary罗红波
 * [ (    )  ]
 * dary罗红波
 * (   [ )   ]
 * dary罗红波
 * (   )   [  {   }  ]
 */
public class Main1 {
    public static void get(String next){
        Stack<Character> stack=new Stack<>();
        boolean flag=false;
        for (int i = 0; i < next.length(); i++) {
            if(next.charAt(i)==')'|| next.charAt(i)==']'|| next.charAt(i)=='}'){
                if(next.charAt(i)==')'){
                    if(stack.isEmpty()||stack.pop()!='('){
                        if(stack.isEmpty()) {System.out.println(-1);flag=true;}
                        break;
                    }
                }
                if(next.charAt(i)==']'){
                    if(stack.isEmpty()||stack.pop()!='['){
                        if(stack.isEmpty()) {System.out.println(-1);flag=true;}
                        break;
                    }
                }
                if(next.charAt(i)=='}'){
                    if(stack.isEmpty()||stack.pop()!='{'){
                        if(stack.isEmpty()) {System.out.println(-1);flag=true;}
                        break;
                    }
                }
            }
            else {
                stack.push(next.charAt(i));
            }
        }
        if(flag!=true&&stack.isEmpty()){
            System.out.println(1);
        }else{
            System.out.println(-1);
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] next ={"((","()]","[()]","([)]","()[{}]"};
        for (String s : next) {
            get(s);
        }
    }
}
