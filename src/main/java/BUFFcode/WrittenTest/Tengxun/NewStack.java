package BUFFcode.WrittenTest.Tengxun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 2
 * 7
 * PUSH 1
 * PUSH 2
 * TOP
 * POP
 * TOP
 * POP
 * POP
 * 5
 * PUSH 1
 * PUSH 2
 * SIZE
 * POP
 * SIZE
 */
class QueueTest1{
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();


    public  void push(int node) {
        stack1.push(node);
    }

    public  int top() {
        if(stack1.empty()&&stack2.empty()){
            return -1;
        }
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }else {
            return stack2.peek();
        }
    }
    public  int pop() {
        if(stack1.empty()&&stack2.empty()){
            return -1;
        }
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
            stack2.pop();
            return 5;
        }else {
            stack2.pop();
            return 5;
        }

    }
}
public class NewStack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int t = Integer.parseInt(scanner.nextLine());
            List<Integer> list = new ArrayList();
            QueueTest1 queueTest = new QueueTest1();
            for (int i = 0; i < t; i++) {
                String s = scanner.nextLine();
                String[] s1 = s.split(" ");
                if (s1[0].equals("add")) queueTest.push(Integer.parseInt(s1[1]));
                else if (s1[0].equals("poll")) {
                    int pop = queueTest.pop();
                    if (pop != 5) list.add(pop);
                } else if (s1[0].equals("peek")) {
                    int top = queueTest.top();
                    list.add(top);
                }
            }
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }
    }
}
