package BUFFcode.NewCodeTest5;

import java.util.Stack;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/54275ddae22f475981afa2244dd448c6?answerType=1&f=discussion
 * 来源：牛客网
 *
 * 1. 分析
 * 队列的特性是：“先入先出”，栈的特性是：“先入后出”
 *
 * 当我们向模拟的队列插入数 a,b,c 时，假设插入的是 stack1，此时的栈情况为：
 *
 * 栈 stack1：{a,b,c}
 * 栈 stack2：{}
 * 当需要弹出一个数，根据队列的"先进先出"原则，a 先进入，则 a 应该先弹出。但是此时 a 在 stack1 的最下面，将 stack1 中全部元素逐个弹出压入 stack2，现在可以正确的从 stack2 中弹出 a，此时的栈情况为：
 *
 * 栈 stack1：{}
 * 栈 stack2：{c,b}
 * 继续弹出一个数，b 比 c 先进入"队列"，b 弹出，注意此时 b 在 stack2 的栈顶，可直接弹出，此时的栈情况为：
 *
 * 栈 stack1：{}
 * 栈 stack2：{c}
 * 此时向模拟队列插入一个数 d，还是插入 stack1，此时的栈情况为：
 *
 * 栈 stack1：{d}
 * 栈 stack2：{c}
 * 弹出一个数，c 比 d 先进入，c 弹出，注意此时 c 在 stack2 的栈顶，可直接弹出，此时的栈情况为：
 *
 * 栈 stack1：{d}
 * 栈 stack2：{c}
 * 根据上述栗子可得出结论：
 *
 * 当插入时，直接插入 stack1
 * 当弹出时，当 stack2 不为空，弹出 stack2 栈顶元素，如果 stack2 为空，将 stack1 中的全部数逐个出栈入栈 stack2，再弹出 stack2 栈顶元素
 */
public class StackModelQueue {

        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            stack1.push(node);
        }
        public void size(){
            System.out.println(stack2.size()+stack1.size());
        }
         public void clear(){
            while(!stack2.empty()){
                stack2.pop();
            }
             while(!stack1.empty()){
                 stack1.pop();
             }
        }
        public void top() {
            if(stack1.empty()&&stack2.empty()){
                System.out.println(-1);
            }
            if(stack2.empty()){
                while(!stack1.empty()){
                    stack2.push(stack1.pop());
                }
                System.out.println(stack2.peek());

            }else {
                System.out.println(stack2.peek());

            }
        }
        public void pop() {
            if(stack1.empty()&&stack2.empty()){
                System.out.println(-1);
            }
            if(stack2.empty()){
                while(!stack1.empty()){
                    stack2.push(stack1.pop());
                }
                System.out.println(stack2.pop());
            }else {
                System.out.println(stack2.pop());
            }
        }

    public static void main(String[] args) {
//        StackModelQueue stackModelQueue=new StackModelQueue();
//        stackModelQueue.push(1);
//        stackModelQueue.push(2);
//        stackModelQueue.push(3);
//        stackModelQueue.pop();
//        stackModelQueue.pop();
//        stackModelQueue.clear();
//        stackModelQueue.size();

        StackModelQueue1 stackModelQueue=new StackModelQueue1();

        stackModelQueue.push(1);
        stackModelQueue.push(2);
        stackModelQueue.push(3);
        System.out.println(stackModelQueue.pop());
        System.out.println(stackModelQueue.pop());
        stackModelQueue.clear();
        stackModelQueue.push(1);
        stackModelQueue.push(2);
        stackModelQueue.push(3);
        System.out.println(stackModelQueue.pop());
        System.out.println(stackModelQueue.peek());
        System.out.println(stackModelQueue.peek());
        stackModelQueue.push(4);
        System.out.println(stackModelQueue.pop());
        System.out.println(stackModelQueue.peek());
        System.out.println(stackModelQueue.pop());
        System.out.println(stackModelQueue.pop());
        System.out.println(stackModelQueue.pop());
        System.out.println(stackModelQueue.size());
    }

}
class  StackModelQueue1{
    private Stack<Integer> stack1=new Stack();
    private Stack<Integer> stack2=new Stack();

    void push(int val){
        stack1.push(val);
    }
    int pop(){
        if(stack1.isEmpty()&&stack2.isEmpty()) return -1;
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    int peek(){
        if(stack1.isEmpty()&&stack2.isEmpty()) return -1;
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
    int size(){
        return stack1.size()+stack2.size();
    }
    void clear(){
        stack1.clear();
        stack2.clear();
    }

}