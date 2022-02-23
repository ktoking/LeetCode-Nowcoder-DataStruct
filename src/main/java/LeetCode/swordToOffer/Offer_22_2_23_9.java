package LeetCode.swordToOffer;

import io.swagger.models.auth.In;

import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 */
public class Offer_22_2_23_9 {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public Offer_22_2_23_9() {
        s1=new Stack<>();
        s2=new Stack<>();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if(s2.isEmpty()){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.isEmpty()?-1:s2.pop();
    }
}
