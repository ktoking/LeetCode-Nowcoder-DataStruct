package BUFFcode.NewCodeTest10;

import java.util.Scanner;

/**
 *链接：https://www.nowcoder.com/questionTerminal/18ecd0ecf5ef4fe9ba3f17f8d00d2d66
 * 来源：牛客网
 *
 * Fibonacci数列是这样定义的：
 * F[0] = 0
 * F[1] = 1
 * for each i ≥ 2: F[i] = F[i-1] + F[i-2]
 * 因此，Fibonacci数列就形如：0, 1, 1, 2, 3, 5, 8, 13, ...，在Fibonacci数列中的数我们称为Fibonacci数。给你一个N，你想让其变为一个Fibonacci数，每一步你可以把当前数字X变为X-1或者X+1，现在给你一个数N求最少需要多少步可以变为Fibonacci数。
 *
 * 输入描述:
 * 输入为一个正整数N(1 ≤ N ≤ 1,000,000)
 *
 *
 * 输出描述:
 * 输出一个最小的步数变为Fibonacci数"
 * 示例1
 * 输入
 * 15
 * 输出
 * 2
 *
 * 题解: 首先构建一个Fibonacci数列，然后从该数列中找到与n最接近的值 在构建数列的时候，如果使用递归，就会
 * 因重复计算产生成倍的时间代价，所以用数组的形式 即：A[n]=A[n-1]+A[n-2] 但是数组又会产生额外的空间
 * 花销，考虑到每次迭代只会用前两项的值，所以我们可以只用三个变量 a b c分别表示每次迭代中的 A[n]
 * A[n-1] A[n-2] 计算数列的过程中，如果发现某一项大于等于n，则迭代就可以停止了。此时n的值介于最后的
 * 两项之间。这时候只要找到n和这两项距离最小者即可
 *
 */
public class FibonacciDemo {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int nextInt = scanner.nextInt();
        int a= 0;
        int b=1;
        int c=1;
        while(c<nextInt){
            a=b;
            b=c;
            c=a+b;
        }
        int len1=nextInt-b;
        int len2=c-nextInt;
        System.out.println(len1>len2?len2:len1);
    }

}
