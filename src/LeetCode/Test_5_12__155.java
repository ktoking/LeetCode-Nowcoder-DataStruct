package LeetCode;

import jdk.nashorn.internal.runtime.regexp.joni.ast.Node;

import java.util.Stack;

/**
 * 方法一：辅助栈
 * 思路
 *
 * 要做出这道题目，首先要理解栈结构先进后出的性质。
 *
 * 对于栈来说，如果一个元素 a 在入栈时，栈里有其它的元素 b, c, d，那么无论这个栈在之后经历了什么操作，只要 a 在栈中，b, c, d 就一定在栈中，因为在 a 被弹出之前，b, c, d 不会被弹出。
 *
 * 因此，在操作过程中的任意一个时刻，只要栈顶的元素是 a，那么我们就可以确定栈里面现在的元素一定是 a, b, c, d。
 *
 * 那么，我们可以在每个元素 a 入栈时把当前栈的最小值 m 存储起来。在这之后无论何时，如果栈顶元素是 a，我们就可以直接返回存储的最小值 m。
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/min-stack/solution/zui-xiao-zhan-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class MinStack {
   private Stack<Integer> stack;
   private Stack<Integer> minstack;

    /** initialize your data structure here. */
    public MinStack() {
       stack=new Stack<>();
       minstack=new Stack<>();
    }

    public void push(int x) {
        if(stack.empty()){
            stack.push(x);
            minstack.push(x);
        }else {
            stack.push(x);
            if(minstack.peek()>x){
                minstack.push(x);
            }else {
                minstack.push(minstack.peek());
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

    public int getMin() {
        return minstack.peek();
    }
}

/**
 * 解法一中用了两个栈去实现，那么我们能不能用一个栈去实现呢？
 *
 * 参考了 这里。
 *
 * 解法一中单独用了一个栈去保存所有最小值，那么我们能不能只用一个变量去保存最小值呢？
 *
 * 再看一下上边的例子。
 *
 * 入栈 3
 * |   |   min = 3
 * |   |
 * |_3_|
 * stack
 *
 * 入栈 5
 * |   |   min = 3
 * | 5 |
 * |_3_|
 * stack
 *
 * 入栈 2
 * | 2 |   min = 2?
 * | 5 |
 * |_3_|
 * stack
 * 如果只用一个变量就会遇到一个问题，如果把 min 更新为 2，那么之前的最小值 3 就丢失了。
 *
 * 怎么把 3 保存起来呢？把它在 2 之前压入栈中即可。
 *
 * 入栈 2 ，同时将之前的 min 值 3 入栈，再把 2 入栈，同时更新 min = 2
 * | 2 |   min = 2
 * | 3 |
 * | 5 |
 * |_3_|
 * stack
 *
 * 入栈 6
 * | 6 |  min = 2
 * | 2 |
 * | 3 |
 * | 5 |
 * |_3_|
 * stack
 *
 * 出栈 6
 * | 2 |   min = 2
 * | 3 |
 * | 5 |
 * |_3_|
 * stack
 *
 * 出栈 2
 * | 2 |   min = 2
 * | 3 |
 * | 5 |
 * |_3_|
 * stack
 * 上边的最后一个状态，当出栈元素是最小元素我们该如何处理呢？
 *
 * 我们只需要把 2 出栈，然后再出栈一次，把 3 赋值给 min 即可。
 *
 * 出栈 2
 * |   |  min = 3
 * | 5 |
 * |_3_|
 * stack
 * 通过上边的方式，我们就只需要一个栈了。当有更小的值来的时候，我们只需要把之前的最小值入栈，当前更小的值再入栈即可。当这个最小值要出栈的时候，下一个值便是之前的最小值了。
 *
 * 作者：windliang
 * 链接：https://leetcode-cn.com/problems/min-stack/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-38/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class MinStack1 {
    private Stack<Integer> stack;
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

    public int getMin() {
        return min;
    }
}

public class Test_5_12__155 {
    public static void main(String[] args) {
        MinStack1 minStack=new MinStack1();
        minStack.push(-5);
        minStack.push(2);
        minStack.push(45);
        minStack.push(-2);
        minStack.push(6);
        minStack.push(-6);
        minStack.push(46);
        minStack.pop();
        minStack.pop();
        int top = minStack.top();
        System.out.println(top);
        System.out.println("最小的是"+minStack.getMin());
    }

}
