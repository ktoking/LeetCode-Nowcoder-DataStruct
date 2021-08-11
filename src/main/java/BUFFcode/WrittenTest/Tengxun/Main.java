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
class QueueTest{
     Stack<Integer> stack1 = new Stack<Integer>();
     Stack<Integer> stack2 = new Stack<Integer>();


    public  void push(int node) {
        stack1.push(node);
    }
    public  int size(){
        return stack2.size()+stack1.size();
    }
    public  void clear(){
        while(!stack2.empty()){
            stack2.pop();
        }
        while(!stack1.empty()){
            stack1.pop();
        }
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
public class Main {


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
            int t = Integer.parseInt(scanner.nextLine());
            List<Integer> list=new ArrayList();
            for (int i = 0; i < t; i++) {
                int q =Integer.parseInt(scanner.nextLine());
                QueueTest queueTest=new QueueTest();
                for (int j = 0; j < q; j++) {
                    String s = scanner.nextLine();
                    String[] s1 = s.split(" ");
                    if(s1[0].equals("PUSH")) queueTest.push(Integer.parseInt(s1[1]));
                    else if(s1[0].equals("POP")) {
                        int pop = queueTest.pop();
                        if(pop!=5) list.add(pop);
                    }
                    else if(s1[0].equals("TOP")) {
                        int top = queueTest.top();
                        list.add(top);
                    }
                    else if(s1[0].equals("SIZE")){
                        int size = queueTest.size();
                        list.add(size);
                    }
                    else if(s1[0].equals("CLEAR")) queueTest.clear();
                }
            }
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
