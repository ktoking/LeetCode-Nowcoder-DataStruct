package BUFFcode.NewCodeTest9;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/ae809795fca34687a48b172186e3dafe
 * 来源：牛客网
 *
 * [编程题]数字颠倒
 * 热度指数：138929时间限制：C/C++ 1秒，其他语言2秒空间限制：C/C++ 32M，其他语言64M
 * 算法知识视频讲解
 * 描述：
 *
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 *
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 *
 *
 *
 * 输入描述:
 * 输入一个int整数
 *
 *
 *
 * 输出描述:
 * 将这个整数以字符串的形式逆序输出
 *
 * 示例1
 * 输入
 * 1516000
 * 输出
 * 0006151
 */

public class StringNixu {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder stringBuilder=new StringBuilder(s);
//        StringBuilder stringBuilder=new StringBuilder();
//        for (int i = s.length()-1; i >=0 ; i--) {  //直接逆序
//            stringBuilder.append(s.charAt(i));
//        }
        stringBuilder.reverse();  //调用StringBuilder

        System.out.println(stringBuilder);

        String ss="DSS";
        String s1 = ss.toUpperCase();
        System.out.println(s1==ss);
        StringNixu stringNixu=new StringNixu();
        ((StringNixu)null).newget();

    }

    public static void newget(){
        System.out.println(1);
    }
}
