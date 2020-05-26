package BUFFcode.NewCodeTest5;

import java.util.Scanner;

/***
 * 链接：https://www.nowcoder.com/questionTerminal/9aaea0b82623466a8b29a9f1a00b5d35
 * 来源：牛客网
 *
 * 有一个神奇的口袋，总的容积是40，用这个口袋可以变出一些物品，这些物品的总体积必须是40。John现在有n个想要得到的物品，每个物品的体积分别是a1，a2……an。John可以从这些物品中选择一些，如果选出的物体的总体积是40，那么利用这个神奇的口袋，John就可以得到这些物品。现在的问题是，John有多少种不同的选择物品的方式。
 *
 * 输入描述:
 * 输入的第一行是正整数n (1 <= n <= 20)，表示不同的物品的数目。接下来的n行，每行有一个1到40之间的正整数，分别给出a1，a2……an的值。
 *
 *
 * 输出描述:
 * 输出不同的选择物品的方式的数目。
 */
public class Package {
    static int[] weight;
    static int count=0;

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        while(scanner.hasNext()){

            int num = scanner.nextInt();
            weight= new int[num];
            for (int i = 0; i < num; i++) {
                weight[i]=scanner.nextInt();
            }
            count(40,num);
        }
    }

    static void count(int s,int n){ //s代表剩余容量,n代表剩余可选物品个数
        if(s==0){
            count++;
            return;
        }
        if(s<0||(s>0&&n<1)){
            count(s-weight[n],n-1);
            count(s,n-1);
        }
    }
}
