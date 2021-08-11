package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Test_7_9__225 {
}

/**
 * 使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 *
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MyStack {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    /** Initialize your data structure here. */
    public MyStack() {
        queue1=new LinkedList();
        queue2=new LinkedList();
    }

    /** Push el...ement x onto stack. */
    public void push(int x) {  //当我们加入元素的时候,首先往非空的里面加,都空就加入第一个队列
         if(queue1.isEmpty()&&queue2.isEmpty()){
             queue1.offer(x);
         } else if(queue1.isEmpty()){
             queue2.offer(x);
         }else {
             queue1.offer(x);
         }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() { //取元素的话,会让一个非空队列所有元素加到另外一个空队列中,只留下非空队列的队首元素,弹出
        if(queue1.isEmpty()&&queue2.isEmpty()){
            return -1;
        } else if(queue1.isEmpty()){
            while (queue2.size()>1){
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }else {
            while (queue1.size()>1){
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }
    }

    /** Get the top element. */
    public int top() { //取元素的话,会让一个非空队列所有元素加到另外一个空队列中,只留下非空队列的队首元素,弹出,并且不能删除这个元素那就再将它加入队列
        if(queue1.isEmpty()&&queue2.isEmpty()){
            return -1;
        } else if(queue1.isEmpty()){
            while (queue2.size()>1){
                queue1.offer(queue2.poll());
            }
            int temp=queue2.poll();
            queue1.offer(temp);
            return temp ;
        }else {
            while (queue1.size()>1){
                queue2.offer(queue1.poll());
            }
            int temp=queue1.poll();
            queue2.offer(temp);
            return temp ;
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty()&&queue2.isEmpty();
    }
}