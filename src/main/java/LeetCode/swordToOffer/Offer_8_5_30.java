package LeetCode.swordToOffer;

import io.swagger.models.auth.In;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 *  
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *  
 *
 * 提示：
 *
 * 各函数的调用总次数不超过 20000 次
 *  
 *
 * 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 辅助栈解法(双栈)
 */
class MinStack {

    Stack<Integer> stack=new Stack<>();
    Stack<Integer> minstack=new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if(minstack.empty()){
            stack.add(x);
            minstack.add(x);
        }else {
            if(x<=minstack.peek()){
                minstack.add(x);
                stack.add(x);
            }else {
                minstack.add(minstack.peek());
                stack.add(x);
            }
        }
    }

    public void pop() {
        stack.pop();
        minstack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minstack.peek();
    }
}

/**
 * 单栈解法
 */
class MinStack1 {
    Stack<Integer> stack;
    int min;
    /** initialize your data structure here. */
    public MinStack1() {
        stack=new Stack<>();
        min=Integer.MAX_VALUE;
    }

    public void push(int x) {
        if(x<=min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.pop()==min){
            min=stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min;
    }
}

public class Offer_8_5_30 {


}


class MinStack2{

    Stack<Integer> s1;Stack<Integer> s2;
    public MinStack2() {
        s1=new Stack<>();
        s2=new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
        s2.push(s2.isEmpty()?x:Math.min(s2.peek(),x));
    }

    public void pop() {
        s1.pop();
        s2.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int min() {
        return s2.peek();
    }

}