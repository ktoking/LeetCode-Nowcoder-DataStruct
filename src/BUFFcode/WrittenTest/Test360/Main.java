package BUFFcode.WrittenTest.Test360;

import java.util.Scanner;

/**
 * 输入描述
 * 输入第一行包含一个正整数n，表示收到的问卷数量。(1<=n<=2000)
 *
 * 接下来有n行，每行有一个由大小写英文字母，数字，下划线组成的字符串，分别表示一份问卷的名字，字符串长度不超过100。
 *
 * 输出描述
 * 输出只有一个整数，表示有效问卷数量。
 *
 *
 * 样例输入
 * 5
 * BA
 * aOWVXARgUbJDG
 * OPPCSKNS
 * HFDJEEDA
 * ABBABBBBAABBBAABAAA
 * 样例输出
 * 3
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int row = scanner.nextInt();
        int count=0;
        for (int i = 0; i < row; i++) {
            if(istrue(scanner.next())){
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean istrue(String s){
        if(s.length()>10) return false;
        for (int i = 0; i < s.length(); i++) {
            if(!Character.isLetter(s.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
