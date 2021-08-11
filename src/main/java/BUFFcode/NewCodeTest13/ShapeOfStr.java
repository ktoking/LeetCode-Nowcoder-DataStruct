package BUFFcode.NewCodeTest13;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/8af708723b0f45f9a80bc80d78d3566e
 * 来源：牛客网
 *
 * 美国总统奥巴马不仅呼吁所有人都学习编程，甚至以身作则编写代码，成为美国历史上首位编写计算机代码的总统。2014年底，为庆祝“计算
 *
 * 机科学教育周”正式启动，奥巴马编写了很简单的计算机代码：在屏幕上画一个正方形。现在你也跟他一起画吧！
 *
 * 输入描述:
 * 输入在一行中给出正方形边长N（3<=N<=20）和组成正方形边的某种字符C，间隔一个空格。
 *
 *
 * 输出描述:
 * 输出由给定字符C画出的正方形。但是注意到行间距比列间距大，所以为了让结果看上去更像正方形，我们输出的行数实际上是列数的50%
 * （四舍五入取整）。
 * 示例1
 * 输入
 * 10 a
 * 输出
 * aaaaaaaaaa
 * a        a
 * a        a
 * a        a
 * aaaaaaaaaa
 */
public class ShapeOfStr {

     public static void main(String[] args) {
         Scanner scanner=new Scanner(System.in);
         String s = scanner.nextLine();
         String[] s1 = s.split(" ");
         Integer n=Integer.parseInt(s1[0]);
         String str=s1[1];

         for (int i = 0; i < ((n+1)/2); i++) { //向上取整(n+1)/2
             for (int j = 0; j < n; j++) {
                 if(i==0||j==0||i==(n+1)/2-1||j==n-1){ //判断条件
                     System.out.printf(str);
                 }else {
                     System.out.printf(" ");
                 }
             }
             System.out.println(); //换行
         }
     }
}


