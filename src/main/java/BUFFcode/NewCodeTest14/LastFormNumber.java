package BUFFcode.NewCodeTest14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/86ede762b450404dbab59352963378e9
 * 来源：牛客网
 *
 * 每个输入包含1个测试用例。每个测试用例在一行中给出10个非负整数，顺序表示我们拥有数字0、数字1、……数字9的个数。整数间用一个空
 * 格分隔。10个数字的总个数不超过50，且至少拥有1个非0的数字。
 *
 *
 * 输出描述:
 * 在一行中输出能够组成的最小的数。
 * 示例1
 * 输入
 * 2 2 0 0 0 3 0 0 1 0
 * 输出
 * 10015558
 */
public class LastFormNumber {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(scanner.nextInt());
        }
        StringBuilder sb=new StringBuilder();
        //将第一个数字拼接到StringBuilder上,拼接完成就退出
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i)!=0){
                sb.append(i); //首位数字
                list.set(i,list.get(i)-1);
                break;
            }
        }

        //将后续所有数字输出
        for (int i = 0; i < list.size(); i++) {
            while(list.get(i)!=0){
                sb.append(i);
                list.set(i,list.get(i)-1);
            }
        }

        System.out.println(sb.toString());

    }
}
